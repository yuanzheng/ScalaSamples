package learning.list

import scala.collection.mutable.{Map=>MMap}
import util.control.Breaks._


class ListLearning {

  
  def concastinateList() {
    val p1 = Map("name"->"lucas", "age"->200)
    val p2 = Map("name"->"song", "age"->2000)
    var people: List[Map[String,Any]] = List()
    
    people = people :+ p1
    people = people :+ p2
    
  }
  
  def emptyList() = {
     val newList: List[String] = List()
     println(s"check list: ${newList.last}")
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
  
  def appendList(): Unit= {
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