package learning.patternmatch


import org.scalatest.FlatSpec
import org.scalatest.Matchers

class PatternMTest extends FlatSpec with Matchers {
  
  "Pattern Match" should "test IF return" in {
    val test  =  new PatternM
    test.replaceIF()
  }
  
  it should "handle None pattern" in {
    val test = new PatternM
    test.nonePattern()
  }
  
  it should "match Option values" in {
    val test = new PatternM
    test.matchOption()
  }
}