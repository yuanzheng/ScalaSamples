package learning.datatypes.map

import scala.collection.mutable.{Map=>MMap}
import scala.collection.immutable.ListMap
import util.control.Breaks._
import java.util.Date

class MapLearning {


  def addNewElementInMapList(): Unit = {
    val rules: List[Map[String, String]] = List(Map(
      "stage_gate" -> "close won"
    ), Map(
      "stage_gate" -> "closed",
      "comparison_operator" -> "greater than"
    ))

    val oldMap: Map[String, Any] = Map("linear_process" -> "NeuralView Contact",
    "mapping_rules" -> rules)

    val newRule: List[Map[String, String]] = rules map (m => if (m.get("comparison_operator") == None) m ++ Map("comparison_operator" -> "Equals")
    else m)

    println(s"new rules: $newRule")

    println(s"old map: $oldMap")

    val newMap: Map[String, Any] = oldMap ++ Map("mapping_rules" -> newRule)

    println(s"new Map: $newMap")
  }


  def zipCreateMap: Unit = {
    val l: List[String] = List("Hello", "world")
    val l2: List[Int] = List(1,2)

    val result: Map[String, Any] = Map() ++ (l zip l2)

    println(s"zip create a map: $result")
  }

  def getMaxValue(): Unit = {
    val t2: Map[Long, Int] = Map("1".toLong -> 2, "99".toLong -> 1, "11".toLong -> -1)
    
  }
  def sortMap(): Unit = {
    val t2: Map[Long, Int] = Map("1".toLong -> 2, "99".toLong -> 1, "12".toLong -> 2, "11".toLong -> -1)
 
    //sort by key
    val result1: ListMap[Long, Int] = ListMap(t2.toSeq.sortBy(_._1):_*)
    println(s"sorted map by key: $result1")
    // sort by value
    val result2: Map[Long, Int] = ListMap(t2.toSeq.sortBy(_._2):_*).toMap
    
    println(s"sorted map by value: $result2")
    
    // high to low (by value values)
    val result3: ListMap[Long, Int] = ListMap(t2.toSeq.sortWith(_._2 > _._2):_*)
     println(s"sorted map by value (high to low): $result3")
     
     var key: Option[Long] = Option(t2.head._1)
     var value: Option[Int] = Option(t2.head._2)
     t2.foreach(f => {
      
      if (f._2 > value.get) {
         key = Option(f._1)
         value = Option(f._2)
       }
       else if (f._2 == value.get && f._1 > key.get)
       {
         key = Option(f._1)
       }
     }
     )
    
     println(s"get the first key value pair: $key, $value}")
  }
  
  
  def mergeTwoMaps(): Unit = {
    val t: Map[Long, Int] = Map("1".toLong -> 12, "11".toLong -> 1)
    val t2: Map[Long, Int] = Map("1".toLong -> 2, "99".toLong -> 1, "11".toLong -> -1)
    
    val t3: Map[Long, Int] = t ++ t2.map{ case (k,v) => k -> (v + t.getOrElse(k,0)) }
    
    println(s"merge results: $t3")
  }
  
  def updateMapValue(): Unit = {
    var test: Map[String, String] = Map("ismlp" -> "good",
      "ismlp_2" -> "morning",
      "ismlp_3" -> "Lucas",
      "ismlp_4" -> "Well",
      "ismlp_5" -> "Done")

    test += ("ismlp" -> "bad")

    println (s"updated result: $test")
  }


  def getValuesFromMap(): Unit = {
    val test: Map[String, String] = Map("ismlp" -> "good",
      "ismlp_2" -> "morning",
      "ismlp_3" -> "Lucas",
      "ismlp_4" -> "Well",
      "ismlp_5" -> "Done")

    val result: List[String] = test.values.toList

    println(s"Check: map to list: $result")
  }

  /*
  def convertMap() = {
    scala.collection.immutable.Map(Map.toSeq:_*)
  }
  * 
  */
  /** All features of the ClassifiedObject, including both classified and unclassified features */
  //final def getObjectFeatures: scala.collection.immutable.Map[String, Any] = scala.collection.immutable.Map((this.classifiedFeatures ++ this.unclassifiedFeatures).toSeq:_*)

  def mapObject() {
    //var m2: Map[String, Any] = _
  }
  
  def loopMap() {
    val result = concatenateTwoMaps.map { x => (x._1, x._2.toString) }
    println(s"See: $result")
  }
  
  def concatenateTwoMaps(): Map[String, Any] = {
    val m1: Map[String, Any] = Map("name"->"song", "age"->200)
    val m2: Map[String, Any] = Map("company"->"insidesales.com", "size"->1000)

    val newMap: Map[String, Any] = m1++m2
    println(s"new Map: $newMap")


    val whattype: Any = m2.get("size").getOrElse("")
    println(s"check get None ${whattype.getClass()}")

    val m3: MMap[String, Any] = MMap("Last"->"song", "new_age"->200)
    val m4: MMap[String, Any] = MMap("company2"->"insidesales.com", "size2"->1000)

    val secondMap: Map[String, Any] = newMap ++ Seq(("Last"->"song"), ("new_age"->200),
                                                    ("company2"->"insidesales.com"), ("size2"->1000))
    println(s"add new map: $secondMap")

    newMap
  }
  
  def mapContain() {
    var prospectId: Long = 0
    var m2: Map[String, Any] = Map("company"->"insidesales.com", "size"->1000.toLong, "location"->(-93.45).toFloat)
    m2.get("location") match {
      case Some(x: Long) => prospectId = x
      case None | _=> println(s"It doesn't contain Long: ${m2.get("location")}")

    }

    println(s"It contains: $prospectId")
    println(s"It Casts to long: ${m2.get("size").get.toString.toLong}")

  }

  def addNewElementToImmutableMap() {
     var m2: Map[String, Any] = Map("company"->"insidesales.com", "size:12"->1000)
     m2 += ("name"->"")//("People" -> people)

     val people: Map[String, Any] = Map("name"->"Lucas Song")
     val tmp: Map[String, Any] = m2++people


     println(s"Add an Element: $m2")

     m2.foreach(f=> {
       f._2 match {
         case string: String => {
           if (!f._2.toString().trim().isEmpty())
             println(s"---- key:${f._1}, and value:${f._2.toString()}")
         }
         case _ =>{
           println(s"---- Others: key:${f._1}, and value:${f._2.toString()}")
         }
       }
     })

  }
  
  def removeFromMap() {
    var m2: Map[String, Any] = Map("company"->"insidesales.com", "size:12"->1000)
    val key = "size" + ":" + "12"
    m2 = Map() ++ m2-key

    println(s"remove element from a map: $m2")
  }
  
  def newBuilder() {
    val result = Map.newBuilder[String, Any]

    result.+=("name"->"Hello world")
    println(s"new Builder 1: ${result.result()}")

    result.+=("age"->123345)
    println(s"new Builder 2: ${result.result()}")

    val tmpMap: Map[String, Any] = Map()
    result.+=("year" -> tmpMap.get("year").getOrElse(""))
    val check: Map[String, Any] = result.result()
    println(s" -- this is the origin: $check")
    check.foreach {
      f => if (f._2 != "") {
        println(s" --- ${f._1} is ${f._2}")
      }
    }

  }
  
  def addNewElementToMap() {
    var m2: Map[String, Any] = Map("company"->"insidesales.com", "size"->1000.toLong)

    m2 += "Age"->2000

    println(s"With new element: $m2")

  }
  
  def convertMapValueType() {
    val oldMap1: Map[String, Any] = Map(
        "name"->"Lucas",
        "age"->200)
// convert 1 
    val newMap: Map[String, String] = Map() ++ oldMap1.toSeq.map(x=>(x._1, x._2.toString()))
    println(s"check map Type: $newMap")
    
    val oldMap2: Map[String, Any] = Map(
        "name"->"song",
        "age"->120)
//convert 2
    val allString: Map[String, String] = oldMap2 map {x=>(x._1, x._2.toString())}
    println(s"allString to String: $allString")
    
    val now = System.currentTimeMillis();
    val date = new Date(now)
    val oldMap3: Map[String, Any] = Map(
        "name"->"song",
        "age"->120,
        "birth"->date,
        "Empty"->"")
//convert 3 -- not true!
    val mapString: Map[String, String] = oldMap3.asInstanceOf[scala.collection.immutable.Map[String,String]]
    if(mapString.get("age").get == classOf[String]){
      println(s"age is Int")
    } else {
      println(s"age is ${mapString.get("age").get.getClass}")
    }
    if(mapString.get("birth").get == classOf[Date]) {
      println(s"birth is Date")
    } else {
      println(s"birth is ${mapString.get("birth").get.getClass}")
    }
    
   
    println(s"new Map to String: $mapString")
    
    var newString: Map[String, String] = Map[String, String]()
    oldMap3 map {x=>{
      if (!x._2.toString().isEmpty())
        newString += (x._1-> x._2.toString())
    }
    }
    println(s"Now the new Map to String: $newString")
    
    // TODO
    /** converting map[string, string] to map[string, any] */
    //val data = x.mapValues(_.asInstanceOf[Any]).toMap
    
    
  }
  /** Pattern matching can also be used for Option values. 
   *  Some functions (like Map.get) return a value of type Option[T] 
   *  which is either a value of type Some[T] or the value None
   */
  
  def mapOptionValues() = {
    val myMap = Map("a" -> 42, "b" -> 43)
    
    def getMapValue(s: String): String = {
      myMap get s match {
        case Some(nb) => "Value found: " + nb
        case None => "No value found"
      }
    }
    
    // ----- equals to ------
    def getMapValue_(s: String): String = myMap.get(s).map("Value found: " + _).getOrElse("No value found")
    
    getMapValue("a")  // "Value found: 42"
    getMapValue_("c")  // "No value found"
  }
  
  // map += Map()
  def buildNewMap() {
    val oldMap: Map[String, Any] = Map(
        "name"->"Lucas",
        "ago"->200)
    val newMap: MMap[String, String] = MMap()
    
    oldMap foreach(x=> newMap += (x._1 -> x._2.toString))
    
    println(s"newMap is: $newMap")
  }
  
  
  
  def updateMap() = {
    val test: Map[String, String] = Map("name"->"Lucas", "Age"->"11")
    val map: Map[String, Any] = Map() ++  test
    val result = map.get("name").get.asInstanceOf[String]
    println(s"see map: $map\n result: $result" )
  }
  def Upper(strings:String*): Seq[String] = {
    strings.map((s:String) => s.toUpperCase())
  }
  
  def printMap() = {
      val testMap: MMap[String, String] = MMap("name"->"Lucas", "title"->"engineer")
      testMap += ("hello"->"new Data")
      val result = testMap map {
          case (key, value) => '\"' + key + "\": " + value
      }
      val show = "{" + (result mkString ", ") + "}"
      println(s"printMap: $show")
  }
  
  def convertMap() = {
      
      val testMap: Map[String, Any] = Map("name"->"Lucas", "age"->200)
           // testMap foreach (x=> map += (x._1->x._2.toString()))
    val map: Map[String, String] =testMap map {x=>(x._1, x._2.toString())}
      println(s"Any map is converted: $map")
  }
  
  def testMap(): Map[String, String] = {
      var test: Map[String, String] = Map("Map test" -> " works")
      
     if (test.size > 2) Map()
     else 
         test
      
  }
  
  def buildMap() = {
      var map = scala.collection.mutable.Map[String, String]()
      val m1 = scala.collection.mutable.Map[String, String]("xx"->"yy")
      val m2 = scala.collection.mutable.Map[String, String]("yy"->"xx")
      
      map ++= m1
      map ++= m2
      
      println(s"New map: $map")
      
  }
  
  def iterateMap() = {
      var map = scala.collection.mutable.Map[String, String]()
      val m1 = scala.collection.mutable.Map[String, Any]("xx"->"yy", "company"->"bbb", "yy"->"xx")
      
      m1 foreach (x=> if(x._1 != "company") map += (x._1->x._2.asInstanceOf[String]))
      
      val immutableMap:Map[String, String] = Map(map.toSeq:_*)
      println(s"filter map: $immutableMap")
  }
  
  def playList(): Unit= {
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
  
  def tmp() = {
      
        val m: MMap[String, Any] = MMap()//person.toMap()
        var map: MMap[String, String] = MMap()
        m foreach (x=> if(x._1 != "company") map += (x._1-> x._2.asInstanceOf[String]))
        Map(map.toSeq:_*)
      
        /*
        val classifiedPerson = new ClassifiedPerson
        person foreach(x=>classifiedPerson.set(x._1, x._2, true))
        classifiedPerson
        * 
        */
  }
  
  def mapIsEmpty() = {
    val test1 = None
    val test2: Option[Map[String, String]] = Some(Map())
    //val test3 = Some(Map("name" -> "lucas"))
    
    check(test2)
    
    def check(map: Option[Map[String, String]])= {
      if (map.isEmpty || map.get.isEmpty){
        println(s"Empty --- This is an Empty map")
      } else {
        println("Empty --- Ok")
      }
    }
    
  }

}