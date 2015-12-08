package learning.mysqldb.orm

import scala.slick.driver.MySQLDriver.simple._
import learning.mysqldb.orm.Unicorn._
import learning.mysqldb.orm.Unicorn.driver.simple._
import scala.slick.jdbc.StaticQuery
import scala.slick.jdbc.GetResult

/** Base repository for Slick MySQL database connectivity and queries
  *
  * All repositories using Slick to connect to MySQL databases should extend this class.
  *
  *  @constructor Create a new Slick Repository
  *  @tparam Id A BaseId for the main Entity handled by this service
  *  @tparam Entity The main Entity handled by this service
  *  @tparam Table An IdTable[Id, Entity] to be used by the Repository
  *  @param query A TableQuery[Table] used to execute slick statements against
  *  @param mapping Implicit mapping used by the BaseIdRepository that this class extends
  */
abstract class SlickRepository[Id <: BaseId, Entity <: WithId[Id], Table <: IdTable[Id, Entity]]
    (override protected val query: TableQuery[Table])
    (override implicit val mapping: BaseColumnType[Id])
    extends BaseIdRepository[Id, Entity, Table](query)(mapping) {

  // Database used for managing session
  val db:Database
  
  def setCurrentTimezone(timezone: String) = {
    // +? operator appends parameters safely to a string to help preven sql injection
    val query = (StaticQuery.u + "SET time_zone = '" +? timezone + "'").execute
  }
  
  /*
   * Implicit session used when running Slick statements
   * Lazy val is needed because we only need it to process one time
   * and we need it to be delayed so that db is defined by the time it's called.
   */
  implicit lazy val session: Session = db.createSession()
  
  /** Gets all [Entity] using an Iterator */
  def getAllWithIterator(): Iterator[Entity] = {
    query.list.iterator
  }

  
  /** Gets a count of all [Entity] */
  def countAll():Int = {

    /* The reason why we do not use slick directly:  !!!!! IMPORTANT !!!!
     * The commented line below was the original implementation.  Performance has
     * dropped significantly running a count(*) query as tables expand past 100k
     * records, so we have moved away from this implementation
     */
    //scala.slick.lifted.Compiled(query.length).run

    /*
     * This implementation, using a direct query seems to perform more inline
     * with performance directly against the database.
     */
    val query = StaticQuery[Int] + "select count(*) from " + this.tableName
    val result:Int = query.first
    result
  }
  
  /** Gets a batch of [Entity] using the parameters as filters
    *
    * @param count     The number of records to get
    * @param offset    The number of records from the beginning from which to
    *                  start capturing
    * @param ascending Whether the result should be ordered ascending or descending
    *                  before applying count and offset filters
    *
    * @return A List of [Entity] matching criteria defined by parameters
    */
  def getBatch(count:Int, offset:Int, ascending:Boolean = true):List[Entity] = {
    if (ascending) {
      var nq = query.sortBy(_.id.asc).drop(offset).take(count)
      nq.list
    } else {
      query.sortBy(_.id.desc).drop(offset).take(count).list
    }
  }

  
  /** Close the db connection */
  def close() = {
    println(s"Closing repository for table: {} this.tableName")
    this.session.close()
  }
  
  
  /** CREATE SUPER METHOD WRAPPERS TO AVOID REQUIRED USE OF SESSION IMPLICIT FOR SUPER METHODS */
  def allIds() = { super.allIds() }
  def afterSave(elem: Entity) = { super.afterSave(elem) }
  def copyAndSave(id: Id) = { super.copyAndSave(id: Id) }
  def create() = { super.create() }
  def deleteAll() = { super.deleteAll() }
  def deleteById(id: Id) = { super.deleteById(id: Id) }
  def drop() = { super.drop() }
  def findAll() = { super.findAll() }
  def findById(id: Id) = { super.findById(id: Id) }
  def findByIds(ids: Seq[Id]) = { super.findByIds(ids: Seq[Id]) }
  def findExistingById(id: Id) = { super.findExistingById(id: Id) }
  def save(elem: Entity) = { super.save(elem: Entity) }
  def saveAll(elems: Seq[Entity]) = { super.saveAll(elems: Seq[Entity]) }
  /** END: CREATE SUPER METHOD WRAPPERS TO AVOID REQUIRED USE OF SESSION IMPLICIT FOR SUPER METHODS */
}