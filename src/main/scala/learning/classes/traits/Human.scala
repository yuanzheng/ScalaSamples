package learning.classes.traits

import scala.collection.mutable.{Map => MMap}
import com.mongodb.DBObject

trait Human {

  var humanFeatures: Map[String, Any] = Map()
  
  def toMap(): Map[String, Any] = humanFeatures
  
  def fromMongoDBObject(dbo: DBObject, normalize: Boolean = false): Human = {
      this
  }
}