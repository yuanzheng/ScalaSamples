package learning.iterator

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class IteratorLearningTest extends FlatSpec with Matchers {
  "IteratorLearning" should "be able to convert Map" in {
     val test = new IteratorLearning
     test.toMapString()
  }
}