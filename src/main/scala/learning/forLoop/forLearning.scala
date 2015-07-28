package learning.forLoop

class forLearning {

  val requestedSymbols = List("MSFT", "IXIC")
  val theSet = List("DJIA", "GSPC", "IXIC", "XAX")
  
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