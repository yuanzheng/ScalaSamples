import scala.util.{Failure, Success, Try}


object streams {

  val y = 2 until 10
  y(7)

  val z = 2 to 10
  z(8)

  def isPrime(x: Int): Boolean = {

    (2 until x) forall (p => (x % p != 0))
  }

  isPrime(5)


  def createList(lo: Int, hi: Int): List[Int] = {
    if (lo >= hi)
      Nil
    else
      lo :: createList(lo + 1, hi)
  }

  val l: List[Int] = createList(1, 10)



  ((2 to 10) filter isPrime) //循环从2到10


  // stream
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    if (lo >= hi)
      Stream.empty
    else
      Stream.cons(lo, streamRange(lo + 1, hi))
  }

  val s: Stream[Int] = streamRange(1, 10)

  val stream = (1 to 100000000).toStream


  stream.filter(_ < 200)
  ((2 to 10).toStream.filter(p => isPrime(p)))(1)
}