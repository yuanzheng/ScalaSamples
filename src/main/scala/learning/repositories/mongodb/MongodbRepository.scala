package learning.repositories.mongodb

import com.mongodb.casbah.Imports._
import learning.configuration.ConfigManager 

/**  
  * 
  */
abstract class MongodbRepository(val configKey: String, val collectionName: String) {

  private var mongoClients: Map[String, MongoClient] = Map()
  
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

  /** Initialize the mongo repository */
  initialize()

  /** Close the db connection */
  def close() = {
    mongoClient.close()
    
    removeMongoClient(host, port)
  }
  
  /** Initialize the mongo client and get references to the db and collection */
  private def initialize() = {
      mongoClient = getMongoClient(host, port, dbName, username, password)
    db = mongoClient(dbName)
    coll = db(collectionName)
  }
  
  
  private def getMongoClient(host: String, port: Int, database: String, username: String, password: String): MongoClient = {

    val key = host+":"+port

    if (mongoClients.get(key).isEmpty) {

      val server = new ServerAddress(host, port)
      //val credentials = MongoCredential.createScramSha1Credential(username, database, password.toCharArray())
      //val mongoClient = MongoClient(server, List(credentials))
      val mongoClient = MongoClient(server)

      mongoClients = mongoClients + (key -> mongoClient)
    }
    mongoClients.get(key).get
  }
  
  private def removeMongoClient(host: String, port: Int) {
    val key = host+":"+port
    
    mongoClients = Map() ++ mongoClients-key
  }
  
}