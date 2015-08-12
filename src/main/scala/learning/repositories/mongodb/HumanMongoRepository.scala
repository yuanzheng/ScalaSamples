package learning.repositories.mongodb

import learning.classes.traits.Human
import com.mongodb.casbah.Imports._
import scala.reflect.runtime._
import scala.reflect.runtime.universe._

class HumanMongoRepository[P <: Human](configKey: String = "", collectionName: String = "") extends MongodbRepository(configKey, collectionName) {

  
  def save(human: P): WriteResult = {
    var m: Map[String, Any] = human.toMap()
    coll.insert(m)
  }
  
  def getBatch(count:Int, offset:Int, ascending:Boolean = true): List[DBObject] = {
    var result: List[DBObject] = List()
    coll.find().skip(offset).limit(count).foreach { x =>
      result = result :+ x
    } 
    result
  }
  
  def findById(id: String): Option[DBObject] = {
    val query_result: Option[DBObject] = coll.findOneByID(new ObjectId(id))
    query_result 
  }
  
  def deleteById(id: String): WriteResult = {
    coll.remove(MongoDBObject("_id" -> new ObjectId(id)))
  }
  
  
  /*private def getClassifiedObjectInstance: P = {
    val cm: ClassMirror = currentMirror.reflectClass(typeOf[P].typeSymbol.asClass)
    val c: MethodSymbol = (typeOf[P].decl(termNames.CONSTRUCTOR).asMethod)
    val cmethod: MethodMirror = cm.reflectConstructor(c)
    cmethod().asInstanceOf[P]
  }*/
}