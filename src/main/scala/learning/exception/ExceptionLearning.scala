package learning.exception

import java.util.Date
import java.text.SimpleDateFormat
import scala.util.control.Exception.catching
import scala.util.Try
import scala.util.control._

class ExceptionLearning {
  
  /** ignore an exception */
  def exceptionIgnore() {
    var result: Date = null
    val dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    val date: String = "2014-02-12T17:28:19.230Z"
    
    scala.util.control.Exception.ignoring(classOf[java.text.ParseException]) {
        result = new Date(new SimpleDateFormat(dateFormat).parse(date).getTime())
    }
  }
  
  // exception will be caught, None will be returned
  def safeStringToLong(str: String): Option[Long] = {
    catching(classOf[NumberFormatException]) opt str.toLong
  }

  def tryControl(): Unit = {
    val tmp: Map[_,_] = Map("song" -> 1)
    val t: Map[String, Any] = Try (tmp.asInstanceOf[Map[String,Any]]).getOrElse(asInstanceOf[Map[String, Any]])
  }

  def catchingException(): Unit = {
    val tmp: Map[String,_] = Map("song" -> 1)
    val t: Option[List[String]] = catching(classOf[ClassCastException]) opt tmp.asInstanceOf[List[String]]
    println(s"What is map: ${t.toString()}")
  }

  def catchSelfDefinedException(): Unit = {
    try {
      safeStringToLong("test")
    } catch {
      // case e @ (_:ConnectionTimeoutException | _:WebServiceException | _:ParseException | _:DomainException) => throw e
      case e: Exception => println("Exception has been caught.")
    }
  }
}