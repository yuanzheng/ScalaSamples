package learning.datatypes.list

import scala.collection.mutable.{Map=>MMap}
import util.control.Breaks._
import java.util.regex.Pattern
import scala.util.matching.Regex

class ListLearning {

  def trimListNumber() = {
    val test: String = "2\r,\r23,100\r\n"
    val b: List[String] = test.split(",").toList.map(_.trim)
    
    println(s"list of numbers: $b")
  }
  
  def convertListIntToString() ={
    val test: List[Int] = List(-111, 40, 2222)
    
    val result: List[String] = test.map(_.toInt.toString)
  }
  
  def convertListToString() = {
    val test: List[Double] = List(-111.675, 40.2319, 2222.1)
    
    val elements: String = test mkString ", "
    
    val location: String = "(" + elements + ")"
    
    println(s"Convert list to String: $location")
    
  }
  
  def listType() = {
    val test1: Map[String, Any] = Map("ordered_gates" -> classOf[List[String]], "location" -> classOf[List[Double]])
    
    val value1: String = "(Contact,Appointment Set,Appointment Held,Qualified Opportunity)"
    val value2: String = "(23.2, -100.09, 123.987)"

    test1.get("location").get match {
      case  a if a == classOf[List[_]] => {
        //if (a.head.getClass() == "")
        println(s"What is the Class: ${a.asInstanceOf[AnyRef].getClass}")
        val pattern: String = "\\(?([-+]?\\d+(.\\d+)?)\\s*(,\\s*([-+]?\\d+(.\\d+)?))*\\)?"
        val patternCompile = Pattern.compile(pattern)
        val matcher = patternCompile.matcher(value2.trim())
        
        if(matcher.matches()) {
          val numGroups = matcher.groupCount 
          println(s"Total elements: $numGroups")
          var message = s"Got doubles: "
          for(i <- 0 until numGroups) {
            val v3 = matcher.group(i)
          
            message += s"$v3 and "
            
          }
          println(message)
        }else {
          val message = s"invalid (longitude, latitude) format- '$value2'"
          println(message)
        }
      }
      case a if a == classOf[List[String]] => {
        
      }
    }
    
  }
  
  def listSize() = {
    val list1: List[String] = Nil
    val list2: List[String] = List()
    val list3: List[String] = List("Hello", "world", "lucas")
    
    list1 match {
      case a::b => println("Pattern=> y: List[a]")
      case Nil => println("Pattern=> Nil")
      case _ => println("Pattern=> Any")
    }
    
    list2 match {
      case a::b => println("Pattern=> y: List[a]")
      case Nil => println("Pattern=> Nil")
      case _ => println("Pattern=> Any")
    }
    
    
    list3 match {
      case a::b if (list3.contains("wold"))=> println("Pattern=> a::b")
      case Nil => println("Pattern=> Nil")
      case _ => println("Pattern=> Any")
    }
  }
  def zipListsToMap() {
    val list1: List[String] = List("name", "age")
    val list2: List[Any] = List("lucas", 200)
    
    val result = list1.zip(list2).toMap
    
    println(s"Two lists were ziped into a Map: $result")
  }
  
  
  def listHeadLast() = {
    val test = List()
    
    println(s"Get empty list Head: ${test.headOption}")
    println(s"Get empty list List: ${test.lastOption}")
    
    val test2 = List("hello")
    
    println(s"Get $test2 Head: ${test2.headOption}")
    println(s"Get $test2 List: ${test2.lastOption}")
    
    val test3 = List("hello", "world")
    
    println(s"Get $test3 Head: ${test3.headOption}")
    println(s"Get $test3 list List: ${test3.lastOption}")
  }
  
  def mapList() {
    val location: List[Double] = List(123.222, -45345.12)
    val map: Map[String, Any] = Map("location"->location)
    
    for (key <- map) {
      
      if (key._1 == "location") {
          val list = key._2.asInstanceOf[List[Double]]
          
          val coordinate = "(" + list(0) + "," + list(1) + ")"
          println(s"This is location: ¥coordinate")
      
      } else {
        println(s"${key._1} and ${key._2}")
      }
    }
  }
  def listMatch() {
    val location: List[Any] = List(123.222, -45345.12)
    var lat: String = ""
      var long: String = ""
      location match {
        case a :: b :: Nil => long = a.toString; lat = b.toString()
        case _ => ""
      }
    
    println(s"Check longtitude and latitude: $long, $lat")
  }
  
  def appendList1() {
    val p1 = Map("name"->"lucas", "age"->200)
    val p2 = Map("name"->"song", "age"->2000)
    var people: List[Map[String,Any]] = List()
    
    people = people :+ p1
    people = people :+ p2
    
  }
  
  def appendList2(): Unit= {
      println("Test breakable:")
      var tlist:List[Map[String,String]] = List[Map[String,String]]()
                                                  //> tlist  : List[Map[String,String]] = List()
      val tmap1:Map[String,String] = Map("h"->"good", "b"->"no good")
                                                      //> tmap1  : Map[String,String] = Map(h -> good, b -> no good)
      val tmap2:Map[String,String] = Map("h"->"morning", "b"->"very good")
                                                      //> tmap2  : Map[String,String] = Map(h -> morning, b -> very good)
      tlist ::=tmap1
      tlist ::=tmap2
      tlist                                           //> res4: List[Map[String,String]] = List(Map(h -> morning, b -> very good), Ma
                                                      //| p(h -> good, b -> no good))
      var count: Int = 0
      for(d <- tlist) {
        breakable {
            //
            val tmp = d.getOrElse("h", "")
            //println("tmp: " + tmp)
            if( tmp == "morning") {
                //println("show: " + tmp)
                if (count < 10)
                    break
            }
            println("check: " + d + "  counter " + count)
            count += 1
        }
      }
          
      
      val mm: MMap[String, String] = MMap(tmap2.toSeq: _*)
      println("Check m map: " + mm)
      
  }
  
  
  def concatenateList() {
    val test1:List[String] = List("DATE,VALUE","2015-01-02,12.230", "2015-01-03,2.430")
    val test2:List[String] = List("again","5102-01-02,12.230", "20-01-03,2.430")
    
    val result = test1 ++ test2
    
    println(s"Concatenate lists: $result")
  }
  
  
  def emptyList() = {
     val newList: List[String] = List()
     println(s"Check empty list head: ${newList.head}")
     println(s"check empty list last: ${newList.last}")
  }
 
  // Using Builder to create List of Map
  def listOfMap() {
    val test:List[String] = List("DATE,VALUE","2015-01-02,12.230", "2015-01-03,2.430")
    //val m1:Map[String,String] = Map("DATE" -> "2015-01-02", "VALUE" -> "12.230")
    //val m2:Map[String,String] = Map("DATE" -> "2015-01-03", "VALUE" -> "2.430")
    val data = List.newBuilder[Map[String, String]]

    for (i <- 1 until test.size) {
        val dateValue = test(i).split(',')
        data ++= List(Map("DATE" -> dateValue(0), "VALUE" -> dateValue(1)))
        
      }
      
      val result = (data.result).toList
    for(m <- result) {
      println("TEST Map: " + m("DATe"))
      println("TEST Map: " + m("VALUE"))
    }
  }
  
  

  def printList() {

    val fruit:List[String] = List("apple", "oranges", "Pears")

    for (a <- fruit) {
      println("test LIST: " + a)
    }

  }
  
  def printListOfMap(): List[Map[String, String]] = {
      val test = List(Map("id" -> "32")) //List(Map("id" -> "32", "lucas"->"song"))
      
      if(test.size == 1 && test.head.size == 1 ) {
          println(s"check list: ${test.head("id")}")
          List()
      } else test
  }
  
  
  def loopList(): Unit = {
    val stocks: List[String] = List("GSPC", "DJIA", "IXIC", "XAX")  
    //var stockBuffer: Buffer[String] = stocks.toBuffer;
    //val numStocksPerCall: Int = 1
    val stockDataUrl: String = "http://finance.yahoo.com/d/quotes.csv?f=sol1ghvxd1&s="
    //stockBuffer.grouped(numStocksPerCall).foreach(stockGroup => {
    stocks.foreach(stockGroup => {
        
        val call = stockDataUrl + stockGroup
        println(s"Group: $call")
    })
  }
  
  
  
  private def playPrivate(test: String): List[Map[String, String]] = {
   
      val t: Map[String, String] = Map("test" -> test)
      val l: List[Map[String, String]] = List(t)
      
      return l
  }//test + " Hello world"
  

}