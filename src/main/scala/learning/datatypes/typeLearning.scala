package learning.datatypes

import learning.classes.traits.Human

object typeLearning {

  /** value definitions: by value and by name
    * note:
    * by name: 等式右边不会被计算，只有“每当”变量被使用的时候才计算，
    * 所以每次使用时都会被计算一次.
    * by value: 当定义时，等式右边会立即被计算， 并把结果赋值给变量。 
    */
  def byName: Int = 2 + change
  var change: Int = 0
  val byValue: Int = 1 + change  // change must be define before val definition
  
  
  /** Defines aliases of tuples, the first element is gender and the second is Human object */
  type people = List[(String, Human)]

  /** lazy : evaluated once when need */
  lazy val testOnce = 20

  /** implicit */

  /** call by value */
  def callByValue(age: Int) = {}
  /** call by value */
  val age: Int = 2000

  /** call by name */
  def callByName(name: => String) = {}
  /** call by name */
  def newAge: Int = 3000
  
  // None type
  def gotNone() = {
    val fieldName: String = "first_name"
   isNone(fieldName) orElse option(fieldName)
  }
  
  private def isNone(value: String): Option[String] = {
    None
  } 

  private def option(value: String): Option[String] = Some("default")
   
  
  /** a sequence of (Int), Int*  */

}