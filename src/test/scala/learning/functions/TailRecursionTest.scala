package learning.functions

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class TailRecursionTest extends FlatSpec with Matchers {
  
  "Tail Recursion" should "give square root" in {
    val test = new TailRecursion
    println(s"sqrt(2) = ${test.sqrt(2)}")
    println(s"sqrt(4) = ${test.sqrt(4)}")
    println(s"sqrt(1e-6) = ${test.sqrt(1e-6)}")
    println(s"sqrt(1e60) = ${test.sqrt(1e60)}")

  }

  it should "give factorial" in {
    val test = new TailRecursion
    println(s"Factorial(3) with No tail recursion = ${test.factorialWithNoTailRecursion(3)}")
    println(s"Factorial(3) with tail recursion = ${test.factorialWithTailRecursion(3)}")
  }
}