package learning.timezone

import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat
import org.joda.time.{DateTime, DateTimeComparator, DateTimeZone}
import org.joda.time.format.{ISODateTimeFormat, DateTimeFormatter, DateTimeFormat}
import scala.util.control.Breaks.{break, breakable}

class TimeZone {
  
  def testToday() {
    val jodaTime1: DateTime = DateTime.now()
    
    println(s"Today time: $jodaTime1")
    println(s"day of week: ${jodaTime1.getDayOfWeek.toString()}")
  }
  def jodaTimeComparision() {
    val date1: String = "2014-03-12T17:28:19.230Z"
    val date2: String = "2014-03-12T17:28:19.231Z"
    
    //val d1: Date = parseStringToJavaUtilDate(date1)
    //val d2: Date = parseStringToJavaUtilDate(date2)
    
    val jodaTime1: DateTime = DateTime.parse(date1)
    println(s"String to Joda time: ${jodaTime1.toString()}")
    
    val jodaTime2: DateTime = DateTime.parse(date2)
    println(s"String to Joda time: ${jodaTime2}")
    
    if (jodaTime1.toString() < jodaTime2.toString())
      println(s"$date1 is before $date2")
  }
  
  def stringToJodaTime() {
    val date1: String = "2014-02-12T17:28:19.230Z"
    val date2: String = "2014-03-12 17:28:19"
    val date3: String = "2014-03-12"
    
    //val d1: Date = parseStringToJavaUtilDate(date1)
    //val d2: Date = parseStringToJavaUtilDate(date2)
    
    val jodaTime1: DateTime = DateTime.parse(date1)
    println(s"String $date1 to Joda time 1: ${jodaTime1.toString()}")
    // same as the one above
    val dt: DateTime = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC).parseDateTime(date1)
    println(s"String $date1 to Joda time 1: ${dt.toString()}")
    
    val dt2: Date = parseStringToJavaUtilDate(date1)
    val jTime: DateTime = parseJaveUtilDateToJodaUTC(dt2)
    println(s"String $date1 to Joba time 1: ${jTime.toString()}")

    // Any time will be converted into UTC timezone in ISO format
    val javaDate: Date = parseStringToJavaUtilDate(date2)
    val startDate: DateTime = parseJaveUtilDateToJodaUTC(javaDate)
    //val startDate: DateTime = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC).parseDateTime(date2)
    println(s"String $date2 to Joda time 2: ${startDate.toString()}")
    
    val javaTime3: Date = parseStringToJavaUtilDate(date3)
    val startDate2: DateTime = parseJaveUtilDateToJodaUTC(javaTime3)
    println(s"String $date3 to Joba time 3: ${startDate2.toString()}")
   
  }
  
  /** Converts ISO time to Java.util.date
    * Note: In MongoDB, the Date format is in ISO8601 which uses "Z" to indicate UTC
    * This function uses the data type converter in JAXB, since JAXB must be able to 
    * parse ISO8601 date string according to the XML Schema specification.
    * 
    * After converting, the time zone is the system current location time zone.
    * e.g. 2015-06-29T22:34:27.000Z, after converting is Mon Jun 29 16:34:27 MDT 2015
    * 
    * @param ISOdate A date in ISO format 
    * @return java.util.date
    */
  def parseMongoTimeToJavaUtilDate(ISOdate: String): Date = {
    val date: Calendar = javax.xml.bind.DatatypeConverter.parseDateTime(ISOdate)
    date.getTime
  }
  
  def UDate() {
    //val tDate = "Wed Feb 12 10:28:19 MST 2014"
    val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val tmp = new Date
    val result = formatter.format(tmp.getTime)
    println(s"Check UDate 1: $result")
    
    
    val tDate2 = "2015-06-29T22:34:27.000Z"
    val tmp2 = parseMongoTimeToJavaUtilDate(tDate2)
    val result2 = formatter.format(tmp2.getTime)
    println(s"Check UDate 2: $result2 <=> $tmp2")
    
    val tmp3: Date = null
    val utcDate: DateTime = new DateTime(tmp3).withZone(DateTimeZone.UTC)
    println(s"After Joda time convertion: $utcDate")
    
  }
  
  // joda time to java time
  def jodaToJavaDate() {
    
    val tDate2 = "2015-06-29T22:34:27.405Z"  // UTC timezone
    val date: Date = parseMongoTimeToJavaUtilDate(tDate2) // UTC -> local timezone
    println(s"Start java time (local timezone): $date")
    
    val timestamp: DateTime = new DateTime(date).withZone(DateTimeZone.UTC)
    println(s"Java time to Joda time convertion: $timestamp")
    
    val calendar: Calendar = Calendar.getInstance()
    calendar.setTime(timestamp.toDate())
    val javaDate: Date = calendar.getTime
    
    println(s"Joda time to JavaTime: $javaDate")
  }

  private def parseStringToJavaUtilDate(date: String): Date = {
    var result: Date = null

    // list of all possible date format
    val allFormats: Array[String] = Array("yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
      "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH", "yyyy-MM-dd", "MM/dd/yyyy")

    //if the input date is not null and not empty, then parse it
    if (date != null && !date.isEmpty()) {

      breakable {
        for (dateFormat <- allFormats) {
            
          if (dateFormat == "yyyy-MM-dd'T'HH:mm:ss.SSSZ") {
            result = parseMongoTimeToJavaUtilDate(date)
          } else {
            scala.util.control.Exception.ignoring(classOf[java.text.ParseException]) {
                result = new Date(new SimpleDateFormat(dateFormat).parse(date).getTime())
            }
          }
          if (result != null) break
        }
      }
    }
    
    result
  }
  
  private def parseJaveUtilDateToJodaUTC(date: Date): DateTime = {
    var timestamp: DateTime = null
    if (date != null)
        timestamp = new DateTime(date).withZone(DateTimeZone.UTC)

    timestamp
  }

}