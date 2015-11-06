package learning.classes.traits

import scala.collection.mutable.{Map => MMap}
import com.mongodb.DBObject

/** Traits are similar to Java interfaces, except they can have non-abstract members */
trait Human {

  val humanId: String   // it is allowed because it is 'trait', it will be implemented by subclass
  var humanFeatures: MMap[String, Any] = MMap()
  
  def setHumanId(id: String): Boolean = {
    if (this.humanId == id) {
      println(s"humanId equals to id $id")
      true
    }
    println(s"humanId (${this.humanId}) doesn't equal to id $id")
        
    true
  }
  
  def toMap(): Map[String, Any] = Map(humanFeatures.toSeq:_*)
  
  def set(feature: String, value: Any): Unit = {
    humanFeatures.put(feature, value)
  }
  
  def fromMongoDBObject(dbo: DBObject, normalize: Boolean = false): Human = {
      this
  }
  
  override def toString() = humanFeatures.toString()
}