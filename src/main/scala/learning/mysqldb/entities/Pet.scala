package learning.mysqldb.entities

import learning.mysqldb.orm.Unicorn._
import learning.mysqldb.orm.Unicorn.driver.simple._
import slick.driver.MySQLDriver.simple._
import java.sql.Timestamp
import scala.slick.collection.heterogenous._
import scala.slick.collection.heterogenous.syntax._
import scala.slick.jdbc._

/** Id class for type-safe joins and queries. */
case class PetId(id: Long) extends AnyVal with BaseId

/** Companion object for id class and ordering for Id */
object PetId extends IdCompanion[PetId]


case class Pet(id: Option[PetId], name: Option[String], age: Option[Int], date_created: Option[Timestamp], date_modified: Option[Timestamp]) extends WithId[PetId]


class PetTable(tag: Tag) extends IdTable[PetId, Pet](tag, "pet") {

  def name: Column[Option[String]] = column[Option[String]]("name")
  def age: Column[Option[Int]] = column[Option[Int]]("age")
  def date_created: Column[Option[Timestamp]] = column[Option[Timestamp]]("date_created", O.AutoInc)
  def date_modified: Column[Option[Timestamp]] = column[Option[Timestamp]]("date_modified", O.AutoInc)
  
  
  override def * = (id.?, name, age, date_created, date_modified) <> (Pet.tupled, Pet.unapply)
  
}