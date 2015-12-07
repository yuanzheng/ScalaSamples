package learning.datatypes

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class typeLearningTest extends FlatSpec with Matchers {
  
  
  "typeLearning" should "show value definitions" in {
    typeLearning.change = 100
    
    typeLearning.byName should be (102)
    typeLearning.byValue should be (1)
    println(s"by name: 2+change = ${typeLearning.byName}")
    println(s"by value: 1+ change = ${typeLearning.byValue}")
    
    typeLearning.change = 1000
    
    typeLearning.byName should be (1002)
    typeLearning.byValue should be (1)
    println(s"by name: 2+change = ${typeLearning.byName}")
    println(s"by value: 1+ change = ${typeLearning.byValue}")
    
  }

  it should "tell value types" in {
    typeLearning.typeCheck()
  }
  
  it should "run implicit objects" in {
    typeLearning.defTest()
  }
}