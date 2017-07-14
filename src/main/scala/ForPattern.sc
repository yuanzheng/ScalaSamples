

object ForPattern {

  val expr: List[String] = List("hello", "world", "pat")


  val str = (1 to 100).toStream

  2 until 15
  def isPrime(x: Int): Boolean = {
    (2 until x) forall (p => {println(s"$p"); x % p != 0})
  }

  isPrime(15)
  (str filter isPrime)(1)


  def from(x: Int): Stream[Int] = {
    x #:: from(x + 1)
  }

  val n = from(1)
  val m = n map (_ * 2)
  val f = n filter (_ % 2 == 0)

  val v: Vector[Int] = Vector(1,2)

  v map (x => 0)
  v


  /**
    *
    * @param capacity, the capacity of each glass
    */
  class Puring(capacity: Vector[Int]) {

    type State = Vector[Int]  // amount of water in each glass
    val initialState = capacity map (x => 0)


    trait Move {
      def change (state: State): State
    }
    case class Empty(glass: Int) extends Move {
      def change(state: State) = state.updated(glass, 0)
    }
    case class Fill(glass: Int) extends Move {
      def change(state: State) = state.updated(glass, capacity(glass))
    }
    case class Pour(from: Int, to: Int) extends Move {
      def change(state: State) = {
        val amount = state(from) min (capacity(to) - state(to)) //最多可到多少水
        var tmp = state.updated(from, state(from) - amount)
        tmp = state.updated(to, state(to) + amount)
        tmp
      }
    }

    val glasses = 0 until capacity.length  // number of glasses
    val move = (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
  }


  val test = new Puring(Vector(4, 7, 9))
  test.move


  val ls: List[Int] = List(1,2,3,4)
  ls.chan
}