


import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.PrivateMethodTester

import learning.Functions


class FunctionsTest extends FlatSpec with Matchers with PrivateMethodTester {
    
    
    
    "A Functions" should "tests a private method" in {
     
        val tPrivate = new Functions
        
        var playPrivate = PrivateMethod[List[Map[String, String]]]('playPrivate)
        
        val t: List[Map[String, String]] = tPrivate invokePrivate playPrivate("Lucas")
        
        println("test: " + t)
    }
    
    

}