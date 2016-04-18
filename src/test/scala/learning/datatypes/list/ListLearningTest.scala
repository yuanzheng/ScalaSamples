package learning.datatypes.list

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ListLearningTest extends FlatSpec with Matchers {

  "List Learning" should "test Head and Last" in {
    val test= new ListLearning
    val thrown = the [java.util.NoSuchElementException] thrownBy test.emptyList()
    
    //test.listHeadLast()
    //test.concatenateList()
    
  }
  
  it should "zip two list into a Map" in {
    val test = new ListLearning
    //test.zipListsToMap()
  }
  
  it should "list match pattern" in {
    val test = new ListLearning
    test.listType()
    //test.listSize()
  }
  
  it should "convert list to String" in {
    val test = new ListLearning
    
    test.convertListToString()
  }
  
  it should "append a new element at the end" in {
    val test= new ListLearning
    test.appendElement()
  }
  
  it should "build string buffer" in {
    val test= new ListLearning
    test.listBufferLearning
  }
}