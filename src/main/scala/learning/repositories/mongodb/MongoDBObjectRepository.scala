package learning.repositories.mongodb


import com.mongodb.casbah.Imports._
import scala.reflect.ClassTag
import scala.reflect.runtime._
import scala.reflect.runtime.universe._

class MongoDBObjectRepository [IS <: TeenMongoDBObject : TypeTag](configKey: String = "", collectionName: String = "") extends MongodbRepository(configKey, collectionName) {

}