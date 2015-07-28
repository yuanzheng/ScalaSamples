package learning
import java.text._
import java.text.SimpleDateFormat
import java.sql.Date
import util.control.Breaks._
import scala.collection.mutable.{Map=>MMap}

import scala.util.parsing.json._

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._
import scala.collection.mutable.Buffer

case class DuplicateRecordException(message: String, cause: Throwable = null) extends Exception(message, cause)
case class testCase(id: Option[Long], name: Option[String])

class Functions {
    
 private def ccToMap(cc: AnyRef) =
  (Map[String, Any]() /: cc.getClass.getDeclaredFields) {
    (a, f) =>
      f.setAccessible(true)
      a + (f.getName -> (f.get(cc).asInstanceOf[Option[Any]]).get)
  }
 

 def testDate() = {
     val d: java.util.Date = new java.util.Date()
     println(s"Today? ${d.toString()}")
     
     // Convert string to date
    val dateformat2:SimpleDateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
    val strdate2: String = "2013-04-02 12:35:42";
    try {
        val newdate:java.util.Date  = dateformat2.parse(strdate2);
        println(s"Second: $newdate");
    } catch {
        case e:ParseException => println(s"${e.printStackTrace()}")
    } 
 }
 
 
 
 
 def testCaseClass() = {
     val newclass = new testCase(Some(123), Some("Lucas"))
   
     println(s"Test Case class to Map:\n ${MMap(ccToMap(newclass).toSeq:_*)}")
 }
 
  def getList[T](s: String): List[T] =
      JSON.parseFull(s).get.asInstanceOf[List[T]]

  protected def testOverride(data: String): Unit = {
      
  }
  
 
  
  def convertAny() = {
      val num: Option[Any] = Some(12.toLong)
      
      num match {
          case Some(x: Long) => println(s"got long: $x")
          case _ => println("got None: $num")
      }
  }
  
  def StringConcat() = {
   var test:String = "hello"
    
   println("test: " + test)

   var newTest = test + " world"
   println("test: " + newTest)
  }
  
  def and(x: Boolean, y: Boolean ) = if(x) y else x

  def testDate(date:String) {

    val d:String = "2015-01-02"

    val date:String = d.replace("-","")

    //val test : Date = new Date(date)
    val ft:SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    val sql_date:Date = new Date(ft.parse(date).getTime())

    println("test sql Date: " + sql_date.toString)
  }

  def testJavaDate(): Unit = {
    val date : java.util.Date = new java.util.Date()
    val sql_date: java.sql.Date = new java.sql.Date(date.getTime())
    println("convert sql date " + sql_date)
  }


  def testDoubleConvert() {
    val v:Double = "22.910".toDouble

    println("see double: " + v)
  }


  
  def testRegex() {

    val file : String= "sdfsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdv" +
    "sdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdv" +
    "Data is not available after 2014-12-01"+
    "sdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdv" +
    "sdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdvsdfsdfsdfsesfesfefsefsefsvdfvdfvsdfvsdvsdvdsvfsdvdsfvdvdfvsdfvsdv"

    val test:String ="Data is not available after"
    
    if(file.contains(test)) {
      println("test")
    }
  }


  def testBitwise(): Unit= {
    val a: String = ""
    val b: String = "world"

    if(a == "" || b == "") {
      println("see Bitwise or")
    }
  }

  def testArray(): Unit = {
    var date: Array[String] = new Array[String](2)
    date(0) = "2015-01-02"
    date(1) = "2015-02-27"

    println("test Array: " + date(0))

  }

  
  
  
  trait f1[-A, +R] {
      def apply(x: A): R
  }
  
  def useFunction() = {
      type jBinding = (String, String)
      val testF = new f1[jBinding, String] {
          def apply(x: jBinding) = x match {
              case (key, value) => key + ": " + value
          }
      }
      
      println(s"show function: ${testF(("hello", "Song"))}")
  }
  
  
  
  
  /*
  trait PartialFunction[-A, +R] extends f1[-A, +R] {
      def apply(x: A): R
      
  }
  def partialMatches() = {
      val f: String => String = { case "ping" => "pong" }
      def apply(x: A): R
      
      
  }
  * 
  */
  
  
  
  
  def testMatch(): Unit = {
      val test: Option[String] = None//Some("23")
      
      var check: Option[Int] = test match {
          case Some(value) => Some(value.toInt)
          case None => None
      }
      
      println(s"check Match: $check")
  }
  /*
  def testDefaultDate(): Unit = {
    //val time:Long = System.currentTimeMillis();
    val time:String = "0000-00-00"
    val d:Date = Date.value(time)

    println("Test defualt-date: " + d.toString() + ", and time: " + time)
  }
  * 
  */
  
 
  
  
  
  
  
  
  def json(): Unit = {
   
      val map: MMap[String, String] = MMap("hello" -> "song", "good" -> "yuanzheng")
      //val json: JValue = parse(map)
      //map.toMap
      
      //println("test map: " + map)
      val test: String = compact(render(Map(map.toSeq:_*)))
      
      println("Json: " + test)
  }
  
  def exceptionT(): Unit = {
        var success: String = "false"

      try {
          throw new Exception("Test: sfsefsfsffa")
          success = "true"
      } catch {
          case e: Exception => {
              println("Error, caugh ! " + e.toString())
          }
      } finally {
          println("Finally ...")
      }
      println("Can you see it? === " + success)
  }
  
  def selfException(): Unit = {
      try {
          throw new DuplicateRecordException("Testing")
      } catch {
          case e:Exception=>{
              println("See: " + e.toString())
          }
      }
  }
  
  def breakFor() = {
      val testList: List[String] = List("Hello", "world", "Lucas")
      var leave: Boolean = false
      var counter: Int = 0
      testList.foreach ( s => {
          if(leave)
              true
          else if(s == "Hello") {
              println(s"we got $s, next ...")
              leave = true
          } else if (s == "Lucas")
              println(s"$s is the last one")
              
          counter += 1
              
      } )
      
      println(s"we're  out !!!!!!, total: $counter")
      
  }
  
  def convertDouble() = {
      val test: String = "138864067.0"
      
      println(s"double convert: ${test.toDouble.toInt.toString.toInt}")
      
      
  }
  
  
  
  def testObject() = {
      val test1: newLearn = new newLearn
      val test2: secondLearn = new secondLearn
      test1.initObject()
      println(s"test1 => ${test1.checkObject()}")
      println(s"test2 => ${test2.checkObject()}")

      
  }
  
   def testException(): Map[String, String] ={
      var test: Map[String, String] = Map()
      try {
          test = Map("Exception" -> "Lucas")
          throw new Exception("hi just get here")
      } catch {
          case e: Exception => test = Map("song" -> " is Lucas!")
      } finally {
          println("testException is done!")
      }
      
      test
  }
  
  
  
  
  
  
}