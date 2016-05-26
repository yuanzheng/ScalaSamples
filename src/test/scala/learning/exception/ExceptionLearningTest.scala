package learning.exception

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ExceptionLearningTest extends FlatSpec with Matchers {

  "ExceptionLearning" should "be able to safeStringToLong " in {
    val exp = new ExceptionLearning
    val result: Option[Long] = exp.safeStringToLong("")
    
    println(s"Convert to option long: $result")
  }
  
  it should "be able to catch cast type exception" in {
    val exp = new ExceptionLearning
    exp.catchingException()

  }
}