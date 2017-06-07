
object polynomials {

  class Poly(val terms: Map[Int, Double]) {

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms2: Map[Int, Double] = terms.withDefaultValue(0.0)

    def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def -(other: Poly) = new Poly((other.terms2 foldLeft terms2)(adjust2))


    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term

      terms.get(exp) match {
        case Some(coeff1) => (exp -> (coeff + coeff1))
        case None => exp -> coeff
      }
    }

    def adjust2(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term

      terms + (exp -> (coeff + terms(exp)))
    }

    override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString "+"

  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

  p1 + p2
  p1 - p2

}
