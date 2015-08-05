package learning.algorithms.sort

import org.joda.time.DateTime

class ScalaSorting {
  
  def jodaTimeSort() {
    val date1: DateTime = DateTime.parse("2015-05-26T16:52:53.000Z")
    val date2: DateTime = DateTime.parse("2015-05-26T22:58:53.000Z")
    val p1: Map[String, Any] = Map("date"->date1,"name"->"lucas")
    val p2: Map[String, Any] = Map("date"->date2,"name"->"Song")
    val times: Seq[Map[String,Any]] = List(p1)
    
    val filteredTimes = times.partition(p=>{
      p.get("date").getOrElse("").toString()<=date2.toString()
    })
    println(s"")
    val firstPart: Seq[Map[String,Any]]  = filteredTimes._1:+p2       
    println(s"Fist Part is: $firstPart")
    val sortedTimes: Seq[Map[String,Any]] = firstPart.sortBy(x=>x.get("date").getOrElse("").toString())
    
    for(i<-sortedTimes.indices)
        println(s"Sorted Joda Time: ${sortedTimes(i)}")
  }

}