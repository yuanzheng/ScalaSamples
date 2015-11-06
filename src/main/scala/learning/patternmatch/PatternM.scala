package learning.patternmatch

class PatternM {
  
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
  
  
  def nonePattern() = {
    val aMap: Map[String, String] = Map("last_name"->"song")
    
    aMap.get("last_name") match {
      case Some(a: String) => println(s"yes, $a")
      case None => ???
    }
    
  }
  

}