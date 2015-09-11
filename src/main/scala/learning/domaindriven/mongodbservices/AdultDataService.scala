package learning.domaindriven.mongodbservices

import learning.repositories.mongodb.AdultMongoRepository
import learning.classes.Adult

class AdultDataService(override val mongoRepo: AdultMongoRepository = new AdultMongoRepository) extends HumanMongoDataService [Adult, AdultMongoRepository](mongoRepo) {

}