package learning.classes.traits

import scala.collection.mutable.{Map => MMap}
import com.mongodb.DBObject

trait Human {

  var humanFeatures: MMap[String, Any] = MMap()
  
  def toMap(): Map[String, Any] = Map(humanFeatures.toSeq:_*)
  
  def set(feature: String, value: Any): Unit = {
    humanFeatures.put(feature, value)
  }
  
  def fromMongoDBObject(dbo: DBObject, normalize: Boolean = false): Human = {
      this
  }
  
  override def toString() = humanFeatures.toString()
}