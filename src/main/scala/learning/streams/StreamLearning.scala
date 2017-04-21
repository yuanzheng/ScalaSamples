package learning.streams

/**
  * Pros:
  * It solves the problem of avoiding unnecessary computations when the tail value of the stream is not needed.
  *
  * Cons:
  * It suffers very serious potential performance problem. And that is that if tail is called several times the corresponding
  * stream will be recomputed each time tail is called. And of course that could by itself cause up to exponential
  * blow up in program complexity.
  * But, it can be avoided by storing the result of the first evaluation of tail and reusing the stored result
  * instead of recomputing it the second and third times and all other times around.
  *
  * Created by ysong on 4/21/17.
  */
class StreamLearning {



  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    println(s"$lo ")

    if (lo >= hi)
      Stream.empty
    else
      Stream.cons(lo, streamRange(lo + 1, hi))
  }

}
