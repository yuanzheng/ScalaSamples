package learning.datatypes.map


import scala.collection.mutable.{Map=>MMap}


class MutableMapLearning {
  
  def addNewElementToMap() {
     var m1: Map[String, Any] = Map("company"->"insidesales.com", "size:12"->1000)
     
     m1.+= ("name" -> "Lucas")

    println(s"all in map: $m1")
     
  }
    
  def check(map: Map[String, String]) = {
    
  }
  
  

}