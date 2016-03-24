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

  /** Initialize the mongo repository */
  initialize()

  /** Close the db connection */
  def close() = {
    println(s"Closing repository for collection [$collectionName]")
    MongoClientFactory.removeMongoClient(host, port)
      
    mongoClient = null
  }
  
  /** Initialize the mongo client and get references to the db and collection */
  private def initialize() = {
    println(s"MongoDB connection is setting: host=$host, port=$port, dbName=$dbName, username=$username, passwd=$password")
    mongoClient = MongoClientFactory.getMongoClient(host, port, dbName, username, password)
    println(s"Is dbName set? ${mongoClient.databaseNames()}")
    db = mongoClient(dbName)
    coll = db(collectionName)
  }
  
  /** Gets a count of all [Entity] */
  def countAll(): Int = {
    println("MongoRepository::countAll")
    coll.count()
  }
  
}  



object MongoClientFactory {
    
  private var mongoClients: Map[String, MongoClient] = Map()

  def getMongoClient(host: String, port: Int, database: String, username: String, password: String): MongoClient = {

    val key = host+":"+port

    if (mongoClients.get(key).isEmpty) {

      val server = new ServerAddress(host, port)
      println(s"Setting up connection to: $key")
      val mongoClient = MongoClient(server)

      println(s"The existed connection are: $mongoClients")
      mongoClients = mongoClients + (key -> mongoClient)
      println(s"Added new connection: $mongoClients")
    }
    mongoClients.get(key).get
  }
  
  def removeMongoClient(host: String, port: Int) {
    println(s"Number of connections was: $mongoClients")
    val key = host+":"+port
    
    mongoClients = Map() ++ mongoClients-key
    println(s"Mongodb connection is closed: $key")
    println(s"Number of connections: $mongoClients")
  }
  
}