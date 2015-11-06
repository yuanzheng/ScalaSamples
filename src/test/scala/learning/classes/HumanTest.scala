package learning.classes

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class HumanTest extends FlatSpec with Matchers {

  
  "Human trait" should "be able to run functions" in {
    val people: Adult2 = new Adult2("12")
    people.humanId should be ("12")
    
    people.setHumanId("21")
    
  }
}