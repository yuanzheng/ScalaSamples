package learning.repositories.mongodb

import learning.classes.Teen

class TeenMongoRepository extends HumanMongoRepository[Teen](configKey = "Human", collectionName = "Teens"){

}