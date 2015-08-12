package learning.repositories.mongodb

import learning.classes.Adult

class AdultMongoRepository extends HumanMongoRepository[Adult](configKey = "Human", collectionName = "Adults"){

}