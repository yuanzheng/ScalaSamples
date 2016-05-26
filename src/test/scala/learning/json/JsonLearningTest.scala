package learning.json


import org.scalatest.FlatSpec
import org.scalatest.Matchers

class JsonLearningTest extends FlatSpec with Matchers {

  "JsonLearning" should "be able to validate Json" in {
    val test = new JsonLearning
    test.validateJson()
 
  }
  
  it should "be able to convert list map" in {
    val test = new JsonLearning
    test.jsonToList()
    
    test.listToJson()
  }
  
}