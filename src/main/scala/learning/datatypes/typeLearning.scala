package learning.datatypes

import learning.classes.traits.Human

class typeLearning {

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
  
  /** a sequence of (Int), Int*  */
  
}