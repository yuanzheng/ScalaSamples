package learning.domaindriven.mongodbservices

import learning.classes.traits.Human
import learning.repositories.mongodb.HumanMongoRepository
import com.mongodb.WriteResult

class HumanMongoDataService [H <: Human, R <: HumanMongoRepository[H]] (val repository: R) extends MongoDataService(repository) {

  
  def save(people: H): WriteResult = {
    println(s"Saving people: it is ${people.getClass}")
    
    val result = repository.save(people)
    
    result
  }
}