package learning.functions

import scala.annotation.tailrec

/**
  * Created by master on 4/22/17.
  */
class Recursion {

  /** GCD, implementation of the greatest common divisor using Euclid's algorithm
    *
    */
  @tailrec
  private def gcd(a: Int, b: Int): Int = {

    if (b == 0)
      a
    else
      gcd(b, a % b)
  }

  /** n! is n * (n-1) * (n -2) * ... * 1
    *
    * @param n
    * @return
    */
  def factorial(n: Int): Int = {

    @tailrec
    def loop(acc: Int, n: Int): Int = {
      if (n ==0)
        acc
      else
        loop(acc * n, n-1)
    }

    loop(1, n)
  }

}
