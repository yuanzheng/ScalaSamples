package learning.datatypes.map

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class MapLearningTest extends FlatSpec with Matchers {

  "Map Learning" should "concatenate two maps" in {
    val learning = new MapLearning
    val result = learning.loopMap()
  }
  
  it should "parse empty map" in {
    val learning = new MapLearning
    learning.mapIsEmpty()
  }

}