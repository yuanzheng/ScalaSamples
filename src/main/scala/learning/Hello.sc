package learning
import java.util.Date
import java.text.SimpleDateFormat
import util.control.Breaks._

object Hello {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var x = 1                                       //> x  : Int = 1
  def increase(i: Int) = i+1                      //> increase: (i: Int)Int
  //increase(x)
  
  var y: Double = 2                               //> y  : Double = 2.0
  y = 10
  y                                               //> res0: Double = 10.0
  val z:Char='a'                                  //> z  : Char = a
  var q:Boolean = true                            //> q  : Boolean = true
  
  
  
  def abs(x:Double): Double = if(x<0) -x else x   //> abs: (x: Double)Double
  
  def sqrtIter(guess:Double, x:Double): Double =
  	if(isGoodEnough(guess, x)) guess
  	else sqrtIter(improve(guess,x), x)        //> sqrtIter: (guess: Double, x: Double)Double
  
  def isGoodEnough(guess:Double, x:Double): Boolean =
  	abs(guess*guess-x)/x < 0.001              //> isGoodEnough: (guess: Double, x: Double)Boolean
  	
  def improve(guess: Double, x: Double): Double =
  	(guess + x/guess)/2                       //> improve: (guess: Double, x: Double)Double
  	
  def sqrt(x:Double): Double = sqrtIter(1.0,x)    //> sqrt: (x: Double)Double
  
  
  
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(2)                                         //> res2: Double = 1.4142156862745097
  
  def getEndDate = {
    var date : Date = new Date()
    val ft:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    
    ft.format(date)
    
  }                                               //> getEndDate: => String
  var date:String = getEndDate                    //> date  : String = 2015-04-27
  
  val job_info = Map("extractor" -> "WeatherUnderground","num_of_threads" -> "4","endpoint" -> "","credentials" -> "asdfSOMEKEY2342")
                                                  //> job_info  : scala.collection.immutable.Map[String,String] = Map(extractor -
                                                  //| > WeatherUnderground, num_of_threads -> 4, endpoint -> "", credentials -> a
                                                  //| sdfSOMEKEY2342)
  val extr:String = job_info("extractor")         //> extr  : String = WeatherUnderground
  val endpoint:String = job_info("endpoint")      //> endpoint  : String = ""
  
  if(endpoint == "")
  	println("no endpoint!")
  else
  	println("endpoint: " +endpoint)           //> no endpoint!
  	
  var mylst: List[Int] = List(1,2,3)              //> mylst  : List[Int] = List(1, 2, 3)
  val result_mylist = mylst ::: List(4,5)         //> result_mylist  : List[Int] = List(1, 2, 3, 4, 5)
  result_mylist                                   //> res3: List[Int] = List(1, 2, 3, 4, 5)
  
  mylst ::= 10
  mylst                                           //> res4: List[Int] = List(10, 1, 2, 3)
  
  mylst.foreach(println(_))                       //> 10
                                                  //| 1
                                                  //| 2
                                                  //| 3
  
  val if_true: Boolean = true                     //> if_true  : Boolean = true
  if(if_true)
  	println("it is true")
  else
  	println("it is false")                    //> it is true
  
  
  // trim
  val stock_string: String = "GSPC"               //> stock_string  : String = GSPC
  def ltrim(s: String) = if (stock_string.startsWith("^")) stock_string.substring(1)
                                                  //> ltrim: (s: String)Any
  val stock_result = ltrim(stock_string)          //> stock_result  : Any = ()
  stock_result                                    //> res5: Any = ()
  
  val empty: String = ""                          //> empty  : String = ""
  //val result: Long = empty.toLong
  //result
  
  var tlist:List[Map[String,String]] = List[Map[String,String]]()
                                                  //> tlist  : List[Map[String,String]] = List()
  val tmap1:Map[String,String] = Map("h"->"good", "b"->"no good")
                                                  //> tmap1  : Map[String,String] = Map(h -> good, b -> no good)
  val tmap2:Map[String,String] = Map("h"->"morning", "b"->"very good")
                                                  //> tmap2  : Map[String,String] = Map(h -> morning, b -> very good)
  tlist ::=tmap1
  tlist ::=tmap2
  tlist                                           //> res6: List[Map[String,String]] = List(Map(h -> morning, b -> very good), Ma
                                                  //| p(h -> good, b -> no good))
  for(d <- tlist) {
  	breakable {
  		val tmp =d.getOrElse("h", "")
  		if( tmp == "morning") {
  			break
  		}
  		println("show: " + tmp)
  		
  	}                                         //> show: good
  }
  
  
  val mapMap: scala.collection.mutable.Map[String, String] = scala.collection.mutable.Map("song"->"hello", "zheng" -> "good")
                                                  //> mapMap  : scala.collection.mutable.Map[String,String] = Map(song -> hello, 
                                                  //| zheng -> good)
  
  val testMap: scala.collection.mutable.Map[String, String] = mapMap + ("zheng"->"test") + ("test" -> "yuan")
                                                  //> testMap  : scala.collection.mutable.Map[String,String] = Map(song -> hello,
                                                  //|  zheng -> test, test -> yuan)
	mapMap                                    //> res7: scala.collection.mutable.Map[String,String] = Map(song -> hello, zhen
                                                  //| g -> good)
                                                  
  
  val l: List[String] = List()//List("hello", "world")
                                                  //> l  : List[String] = List()
  l match {
  			case List("hello", "world") => println("good list")
        case List() =>
          throw new IllegalArgumentException("empty list!")
  }                                               //> java.lang.IllegalArgumentException: empty list!
                                                  //| 	at learning.Hello$$anonfun$main$1.apply$mcV$sp(learning.Hello.scala:112)
                                                  //| 
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at learning.Hello$.main(learning.Hello.scala:6)
                                                  //| 	at learning.Hello.main(learning.Hello.scala)
  
  
  
  
  /*
  val interMap: Map[String, String] = Map("People"->"{hello}", "Company"->"{good}")
  
  interMap.foreach{
  key=> println(s"${key._1}")
  }
  */
  
  // ; if(key._1=="People") println(s"we go $key._2") else println(s"$key._1 and $key._2")
  type Set = Int => Boolean
  
  def singletonSet(elem: Int): Set = Set(elem)
  val tSet: Set = singletonSet(1)
  tSet
  
  
  
  
  
}