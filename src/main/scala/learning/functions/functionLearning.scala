package learning.functions

class functionLearning {
  
  
  /** Higher-Order-Function: takes other functions as parameters, or whose result is a function */
  private def sum1(f: Int => Int)(a: Int, b: Int): Int = {
     var result: Int = 0;
      for(i <- a to b) result += f(i)
      
      result
  }

  /** or using recursion */
  private def sum1_recursion(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b)
      0
    else
      f(a) + sum1_recursion(f)(a+1, b)
  }
    
  // above 2 functions equals to
  
  /** returns a function that takes two integers and returns an integer */
  private def sum2(f: Int => Int): (Int, Int) => Int = {  
    def sumf(a: Int, b: Int): Int = { 
      var result: Int = 0;
      for(i <- a to b) result += f(i)
      
      result
    }  
    sumf  
  } 
    
  private def square(x: Int): Int = x*x 
  
  def sumAll(start: Int, end: Int) = {
    val result = sum1(square)(start, end)
    println(s"Sum from $start to $end is $result")
  }
  
  /** Nested Functions */
  def sumAllFromNestedF(start: Int, end: Int): Unit = {
    // Nested Function:
    def wrapIt(x: Int) = "Sum from " + start + " to " + end + " is " + x.toString()
    
    val result = sum2(square)(start, end)
    /** or 
      val returnedF = sum2(square) 
      val result = returnedF(start, end)
     *  */
    // using nested function
    println(wrapIt(result))
  }
  
  /** Annonymous Function */
  def testAnnonymousFunction(): Unit = {

    val result: Int = sum1(x => x*x)(3, 5)
    println(s"anonymous function is passed as parameter to sum1, the result should be 50 == $result")
  }
    
    
  /** Currying */
    
  def sqrt(x: Double) = fixedPoint(y => x/y)(2)

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    val check: Double = f(firstGuess)

    println(s"function(firstGuess): $check")   //1.0
  }
    
}