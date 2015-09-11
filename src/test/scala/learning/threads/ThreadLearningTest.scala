package learning.threads

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ThreadLearningTest extends FlatSpec with Matchers {
  
  "Thread Test" should "create threads" in {
    val test = new  ThreadLearning
    new Thread(test).start()
        new Thread(test).start()
    new Thread(test).start()
    new Thread(test).start()

  }

}