package learning.domaindriven.mongodbservices

import learning.repositories.mongodb.MongodbRepository

class MongoDataService(val mongoRepo: MongodbRepository) {

  /** Close the connection to Mongo */
  def close() = mongoRepo.close()
}