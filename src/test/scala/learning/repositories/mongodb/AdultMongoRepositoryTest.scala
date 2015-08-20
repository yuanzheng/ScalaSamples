package learning.repositories.mongodb

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import learning.classes.Adult

class AdultMongoRepositoryTest extends FlatSpec with Matchers {
  
  "AdultMongoRepo" should "save Human" in {
    var repo:AdultMongoRepository = null
    try {
        repo = new AdultMongoRepository
        val people: Adult = new Adult("12")
        people.set("firstName", "Lucas")
        people.set("age", 200)
        repo.save(people)
    }catch {
      case e:Exception => println(s"try to save Adult in Mongo",e)
    } finally{
      try{
        if (repo != null) repo.close()
      } catch {
        case ex: Exception => println(s"Adult Mongo cannont be closed.", ex)
      }
    }
  }

}