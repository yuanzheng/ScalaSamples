package learning.mysqldb.repositories

import learning.mysqldb.orm.SlickRepository
import learning.mysqldb.orm.Unicorn.driver.simple._
import learning.mysqldb.entities.{HumanId, Human, HumanTable}
import learning.mysqldb.orm.SourceDBConnection

class HumanRepository(val sourceKey: String) extends SlickRepository[HumanId, Human, HumanTable](TableQuery[HumanTable]) with SourceDBConnection {
  
}