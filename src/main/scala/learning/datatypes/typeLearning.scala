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
  implicit def repo: Repository = new Repository("Lucas:1000")
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
  
  
  
  def typeCheck(): Unit = {
    val t1: String = "Hello world"
    val t2: Long = 31//"31".toLong
    val t3: Map[String, String] = Map("name" -> "Lucas", "company" -> "ISDC")
    
    matchTypes(t1)
    matchTypes(t2)
    matchTypes(t3)
  }
  
  private def matchTypes(value: Any): Unit = {
    val key: String = "id"
    value match {
      case number: Long => if (key == "source_id") println(s"I am a Long type: $number")
      case string: String => println(s"It is a String type: $string")
      case map: Map[_, _] => println(s"we got a map type: $map")
    }
    
  }
  
  
  def defTest(): Unit = {
    println("Start def test")
     val s: Service = new Service()
    s.callRepo()
    s.callRepo()
    println("End def test")
  }
  
  
  
  
}

class Service() {
  def callRepo()(implicit r: Repository) = {
    secondRepo(1)
    secondRepo(2)
    secondRepo(3)
  }
  
  def secondRepo(num: Int)(implicit r: Repository) = {
    r.counter(num)
    r.counter(num+1)
  }
}

class Repository(sourcekey: String) {
  
  toPrint()
  
  def toPrint(): Unit = {
    println(s"This is the source key: $sourcekey")
  }
  
  def counter(num: Int): Unit = {
    println(s"new counter: $num")
  }
}