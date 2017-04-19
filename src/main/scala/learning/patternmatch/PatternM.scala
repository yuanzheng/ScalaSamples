package learning.patternmatch

import java.util.regex.Pattern

import scala.util.matching.Regex


class PatternM {

  def patternMatch2(): Unit = {
    /*
    val pattern: String = "^ext.*id$"
    val patternCompile = Pattern.compile(pattern)
    val matcher = patternCompile.matcher(data._1.trim())

    if (matcher.matches())
      (data._1, Some(data._2.toString))
    else
      (data._1, Some(data._2))
      */
  }

  def patternMatch(): Unit = {
    val pattern = "(0*|\\s)".r
    val test: String = ""

    test.trim match {
      case pattern(c) => println(s"$test is matching the $pattern")
      case _ => println("No ...")
    }

    val pattern2 = "ext_(lead|opportunity|contact|account)_id".r
    val test2: String = "ext_lead_id"
    test2.trim match {
      case pattern2(c) => println(s"$test2 is matching the $pattern2")
      case _ => println("No ...")
    }


    /*
    if (test.trim.matches(pattern))
      println(s"$test is matching the $pattern")
    else
      println("No, $test doesn't match the $pattern")
    */
  }

  def patternSearch(): Unit = {
    val pattern = new Regex("(B|b)(E|e)(A|a)(R|r)(E|e)(R|r)")
    val test: String = "BeaRER Hello world"

    val result: String = test.toLowerCase.startsWith("bearer") match {
      case true  => (pattern replaceFirstIn(test, "")).trim
      case false => test
    }

    println(s"pattern replaced: $test  ->  $result")
  }

  def numberPatternMatch(): Unit = {
    val pattern = "\\[[+-]?([0-9]*[.])?[0-9]+,[+-]?([0-9]*[.])?[0-9]+\\]".r
    val test: String = "[12.234,-2.1]"

    test match {
      case pattern(c) => println(s"pattern matched!")
      case _ => println(s"pattern doesn't match")
    }


  }

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