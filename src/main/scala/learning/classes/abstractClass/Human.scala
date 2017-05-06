package learning.classes.abstractClass

import com.mongodb.DBObject

import scala.collection.mutable.{Map => MMap}


/** abstract class can contain members which are missing implementation
  * no instances of an abstract class can be created with the operator new
  *
  */
abstract class Human {

  val name: String
  val humanId: String   // abstract // it is allowed because it is 'trait', it will be implemented by subclass
  var humanFeatures: MMap[String, Any] = MMap()

  def include(name: String): Boolean    // abstract method

  // method can be overrided
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
  
  override def toString = humanFeatures.toString()
}