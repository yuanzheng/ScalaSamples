package learning.mysqldb.entities

import java.sql.Timestamp
import learning.mysqldb.orm.Unicorn._
import slick.driver.MySQLDriver.simple._

/** Id class for type-safe joins and queries. */
case class HumanId(id: Long) extends AnyVal with BaseId

/** Companion object for id class and ordering for Id */
object HumanId extends IdCompanion[HumanId]


case class Human(id: Option[HumanId], name: Option[String], gender: Option[String], age: Option[Int], pet_species: Option[String], date_created: Option[Timestamp], date_modified: Option[Timestamp]) extends WithId[HumanId]


class HumanTable(tag: Tag) extends IdTable[HumanId, Human](tag, "human") {

  def name: Column[Option[String]] = column[Option[String]]("name")
  def gender: Column[Option[String]] = column[Option[String]]("gender")
  def age: Column[Option[Int]] = column[Option[Int]]("age")
  def pet_species: Column[Option[String]] = column[Option[String]]("pet_species")
  def date_created: Column[Option[Timestamp]] = column[Option[Timestamp]]("date_created", O.AutoInc)
  def date_modified: Column[Option[Timestamp]] = column[Option[Timestamp]]("date_modified", O.AutoInc)
  
  
  override def * = (id.?, name, gender, age, pet_species, date_created, date_modified) <> (Human.tupled, Human.unapply)
  
}