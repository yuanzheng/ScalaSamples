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
}