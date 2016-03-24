package learning.repositories.mongodb

import com.mongodb.DBObject
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.conversions.scala._

class NeuralMongoRepository(configKey: String = "", collectionName: String = "") extends MongodbRepository(configKey, collectionName) {
  
  def findOneBy(id: String): String = {
    //println(s"Find one record by filter: '$id")
    val result: Option[DBObject] = coll.findOne(MongoDBObject("company_id" -> id))
    val source_key: String = result match {
      case Some(v: DBObject) => v.get("source_key").toString
      case None => ""
    }
    
    source_key
  }
  
}