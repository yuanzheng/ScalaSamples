package learning.repositories.mongodb

import com.mongodb.casbah.Imports._
import learning.configuration.ConfigManager 

abstract class MongodbRepository(val configKey: String, val collectionName: String) {

  /** Setup configuration values */
  lazy val config = ConfigManager.getConfig()
  lazy val host = config.getString("mongo." + configKey + ".host")
  lazy val port = config.getInt("mongo." + configKey + ".port")
  lazy val dbName = config.getString("mongo." + configKey + ".database_name")
  lazy val username = config.getString("mongo." + configKey + ".username")
  lazy val password = config.getString("mongo." + configKey + ".password")

  /** Setup mongo classes */
  var mongoClient: MongoClient = _
  var db: MongoDB = _
  var coll: MongoCollection = _

}