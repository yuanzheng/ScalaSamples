package learning.domaindriven.mongodbservices

import learning.repositories.mongodb.TeenMongoRepository
import learning.classes.Teen

class TeenDataService(override val mongoRepo: TeenMongoRepository = new TeenMongoRepository) extends HumanMongoDataService[Teen, TeenMongoRepository](mongoRepo) {
  
}

