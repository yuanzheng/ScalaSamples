
import scala.util.{Failure, Success, Try}

object TryLearning {


  val row1: Vector[Char] = Vector('q','w','e')
  val row2: Vector[Char] = Vector('a','s','d')
  val row3: Vector[Char] = Vector('z','x','c')
  val row4: Vector[Char] = Vector('-','-','-')

  val matrix: Vector[Vector[Char]] = Vector(row1, row2, row3, row4)

  Try(matrix(2)(1) != '-') match {
    case Success(v: Boolean) => v
    case Failure(e) => false
  }


  row1.indexOf('q')
  row1.indexOf('w')
  row1.indexOf('p')
  val r = matrix.indexWhere(v => v.indexOf('a') >= 0)
  val c = matrix(r).indexOf('a')


  case class Pro(r: Int, c: Int)

  val a = Pro(2,2)
  val b = Pro(1,2)
  a==b

}