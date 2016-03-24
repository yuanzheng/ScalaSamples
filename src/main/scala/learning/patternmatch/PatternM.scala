package learning.patternmatch

class PatternM {
  
  def matchOption() = {
    def check(value: Option[Any]): String = {
      value match {
        case Some(a: String) if(!a.isEmpty()) => "match option is valid"
        case _ => "Invalid match option"
      }
    }
    
    println(s"Check 1 string, ${check(Some("Hello world"))}")
    println(s"Check 2 empty, ${check(Some(""))}")
    println(s"Check 3 None, ${check(None)}")
    println(s"Check 4 Long, ${check(Some("12".toLong))}")
    println(s"Check 5 Int, ${check(Some(11))}")
  }
  
  
  def replaceIF() = {
    val str1 = ""
    val str2 = ""
    
   println(s"IFReturn boolean value: ${ifReturn()}")
    
    matchInIF()
  }
  
  
  def matchInIF() = {
     println(s"IFReturn pattern boolean value: ${stringPattern()}")
  } 
    
  
  private def ifReturn(): Boolean = {
    val str1 = "as"
    val str2 = "as"
    
    if (!str1.isEmpty() && !str2.isEmpty()) {
      
      str1 == str2
    }
    else
     false
  }
  
  private def stringPattern(): Boolean = {
    val str1 = "as"
    val str2 = "as"
    
    if (!str1.isEmpty() && !str2.isEmpty()) {
      (str1, str2) match {
        case _ => str1 == str2
      }
    } else {
      false
    }
  }
  
  def length[A](list : List[A]) : Int = list match {
    case _ :: tail => 1 + length(tail)
    case Nil => 0
  }
  
  
  def nonePattern() = {
    val aMap: Map[String, String] = Map("last_name"->"song")
    
    aMap.get("last_name") match {
      case Some(a: String) => println(s"yes, $a")
      case None => ???
    }
    
  }
  

}