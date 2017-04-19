package learning.mysqldb.repositories

import learning.mysqldb.orm.Unicorn._
import learning.mysqldb.orm.Unicorn.driver.simple._
import learning.mysqldb.entities.{PetId, Pet, PetTable}
import learning.mysqldb.orm.SlickRepository
import org.joda.time.DateTime
import scala.slick.jdbc.StaticQuery

class PetRepository extends SlickRepository[PetId, Pet, PetTable](TableQuery[PetTable]) with AnimalDBConnection {

  def countPetAdded(startDate: DateTime): Int = {
    2
  }


  def test() = {
    /*
   val sql: String = s"select handle, model_definition, model_transformation, probability_data from model_algorithm_state_old"

   try {
     val query = StaticQuery[(String, String, String, String)] + sql
     query.list
   } catch {
     case ex:com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException => {
       //logger.error(s"SQL error occurred fetching columns id and interaction_id from table $tableName. Message: ", ex)
       throw new is.exception.DataSourceException(s"SQL error occurred fetching columns id and interaction_id from table:.")
     }
     case ex:Exception => {
       //logger.error(s"SQL error occurred fetching columns id and interaction_id from table $tableName. Message: ", ex)
       throw new is.exception.DomainException(s"SQL error occurred fetching columns id and interaction_id from table .")
     }
   }
   */
  }
}