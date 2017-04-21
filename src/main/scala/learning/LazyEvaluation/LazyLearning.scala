package learning.LazyEvaluation

/** laziness means do things as late as possible, and never do them twice.
  *
  * There're two problems with lazy evaluation which are essentially rooted in the fact that lazy evaluation is quite
  * unpredictable in when computations happen. And how much space they take.
  * Created by ysong on 4/21/17.
  */
class LazyLearning {

  //not be evaluated immediately, but every time you call x the expression is reevaluated!
  def x: Int = 12/0


  def test(): Unit = {
    println(s"lazy ...")
    val x = {println("x"); 1}
    lazy val y = {println("y"); 2}
    def z = {println("z"); 3}

    z + y + x + z + y + x
  }

}
