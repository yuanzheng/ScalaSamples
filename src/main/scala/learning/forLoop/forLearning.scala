package learning.forLoop

import scala.collection.mutable.{Map=>MMap}
import learning.classes.caseclass.GlobalPersonSellableTermLevel

class forLearning {

  val requestedSymbols = List("MSFT", "IXIC")
  val theSet = List("DJIA", "GSPC", "IXIC", "XAX")

  def updateCaseClassObject(): Unit = {

    val t1= new GlobalPersonSellableTermLevel(
      Option(1.toLong),
      Option(22.toLong),
      Option(33),
      Option(44),
      Option("datacreated"),
      Option("datamodified")
    )
    val t2 = new GlobalPersonSellableTermLevel(
      Option(1.toLong),
      None,
      Option(333),
      Option(444),
      None,
      Option("datamodified")
    )

    //val r = t1.map(x => for(a <- x) yield a)
    //println(s"Global Case Class: $r")
  }

  def forFor(): Unit = {

    val result = for {
      each <- List(100,101,102,103)
      col <- 0 to 5
    } yield col :: List(each)

    println(s"forFor: $result")
  }

  
  def forCount() = {
    
    for(i <- 0 to 3)
    {
      println(s"Count: $i")
    }
  }
  def forFilter() = {
      
      val result = forYield(theSet)
                  
      println(s"what is it: $result")
          
     result.foreach(eachStock => {
      println(s"get in here? $eachStock")
    })
      
  }
  
  private def forYield(symbolSet: List[String]): List[String] = {
    var quandlSymbols: List[String] = List()

    if (requestedSymbols.length != 0) {
        quandlSymbols = for {
            symbol <- requestedSymbols
            if (symbolSet.contains(symbol))
        } yield symbol
        
        
    } else quandlSymbols = symbolSet 
    
    quandlSymbols
  }

  def yieldListMap(): Unit = {
    val m1: Map[String, String] = Map("test1" -> "hello", "test2" -> "world")
    val m2: Map[String, String] = Map("test1" -> "good", "stage_gate" -> "close win")
    val linearP1: List[Map[String, String]] = List(m2, m1)

    val m3: Map[String, String] = Map("test1" -> "hello", "stage_gate" -> "close W")
    val m4: Map[String, String] = Map("test1" -> "good", "test2" -> "better")
    val linearP2: List[Map[String, String]] = List(m3, m4)

    val results = Option(List(linearP1, linearP2))

    var selectedR: List[List[Map[String, String]]] = List()

    results match {
      case Some(head::tail) => {
        for (linearP <- results.get) {
          // Check each linear process, and each linear process has multiple rules
          var foundIt: Boolean = false
          val rules: Iterator[Map[String, String]] = linearP.iterator
          while (rules.hasNext && !foundIt) {
            // each rule of linear process
            val nextRule: Map[String, String] = rules.next()
            if (nextRule.exists(_._1 == "stage_gate") && nextRule.get("stage_gate").get.equalsIgnoreCase("Close win")) {
              selectedR ::= linearP
              foundIt = true
            }
          }

        }
      }
      case _ =>
    }


    println(s"see linearP: $selectedR")





  }


  def foreachList(): Unit = {
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
  
  def forSize() {
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
  
  
}