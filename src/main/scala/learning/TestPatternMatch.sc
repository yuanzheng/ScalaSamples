
object pattern {


  val f: PartialFunction[String, String] = {
    case "ping" => "pong"
  }

  f("ping")

  f.isDefinedAt("ping")
  f.isDefinedAt("pong")



  trait MyFunction[-A, +R] extends Function1[A, R] {
    def apply(x: A): R
    def isDefinedAt(x: A): Boolean
  }


  class first extends MyFunction[String, String] {
    def apply(x: String) = x match {
      case "ping" => "pong"
    }

    def isDefinedAt(x: String) = x match {
      case "ping" => true
      case _ => false
    }
  }

  val t = new first
  t("ping")
  t.isDefinedAt("sdf")
  t.isDefinedAt("ping")


}
