package learning.mysqldb.orm

import org.virtuslab.unicorn.{HasJdbcDriver, LongUnicornCore}
import scala.slick.driver.MySQLDriver

object Unicorn extends LongUnicornCore with HasJdbcDriver {
  val driver = MySQLDriver

}