package learning.functions


import org.scalatest.FlatSpec
import org.scalatest.Matchers


class functionLearningTest extends FlatSpec with Matchers {

  "Functions" should "include Higher-Order-Function" in {
    val fun = new functionLearning
    fun.sumAll(1,3)
    fun.sumAllFromNestedF(1,3)
  }
  
}