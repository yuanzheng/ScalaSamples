package learning.objects

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import learning.classes.Adult
import learning.classes.traits.Human

class ObjectLearningTest extends FlatSpec with Matchers {

  "Object" should "select a class which wants to use" in {
    val test = new ObjectLearning
    println(s"Get class: ${test.selectPeople("Adult").toString()}")
    //test.selectPeople("Adult").getClass should be ("Human")
  }
}