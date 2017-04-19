package learning.forLoop

import org.scalatest.FlatSpec
import org.scalatest.Matchers

/**
  * Created by ysong on 2/3/17.
  */
class forLoopTest extends FlatSpec with Matchers {


  "forLoop" should "be able to List Map" in {
    val test = new forLearning
    test.yieldListMap()
  }

}
