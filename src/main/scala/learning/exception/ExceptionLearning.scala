package learning.exception

import java.util.Date
import java.text.SimpleDateFormat
import scala.util.control.Exception.catching

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


}