package learning.functions

trait Function1[A, B] {
  def apply(x: A): B
}

/** function values are treated as objects
  * Created by ysong on 5/8/17.
  */
class FunctionAsObject extends Function1[Int, Int]{

  def apply(x: Int): Int = x * x
}


object ApplyFunction {

  def testFunctionAsObject = {


    val f = new Function1[Int, Int] {
      def apply(x: Int): Int = x * x
    }

    println(s"function is object: ${f.apply(3)}")
  }
}
