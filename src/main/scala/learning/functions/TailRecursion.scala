package learning.functions

import scala.annotation._

class TailRecursion {

  /**
   * Block内的定义只有在block内才可以看见
   * Block内的定义在Block范围内shadow了Block外的相同名字的定义, 亦即同样一个名字, 如果在Block内外都定义了, 则Block内只会看到Block内的定义值, 但是该定义不会改变Block外相同名字的变量的值
   * Block内可以看到Block外的定义
   */
  def sqrt(x: Double): Double = {
    def abs(x: Double) = if (x < 0) -x else x
 
    /** One can require that a function is tail-recursive using a @tailrec annotation
     *  If the annotation is given, and the implementation of function were not tail recursive, an error would be issued.
     *  
     */
    @tailrec
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
 
    def improve(guess: Double) = (guess + x / guess) / 2
 
    def isGoodEnough(guess: Double) = abs(guess * guess - x) / x < 0.001
 
    sqrtIter(1.0) 
  }
  
  
  /** factorial: n!, 1*2*3* ... * n
   * 
   */
  def factorialWithNoTailRecursion(x: Int): Int = {
    if(x == 0) 1 else x*factorialWithNoTailRecursion(x-1)
  }
  
  
  /**
   * factorial, using tail recursion
   */
  def factorialWithTailRecursion(x: Int): Int = {
    @tailrec
    def loop(acc: Int, n: Int): Int =
    if (n==0) acc
    else loop(acc * n, n - 1)
  
    loop(1, x)
  }
  
}