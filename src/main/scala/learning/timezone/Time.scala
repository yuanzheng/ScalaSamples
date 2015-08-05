package learning.timezone

import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat
import org.joda.time.{LocalDateTime, DateTime, DateTimeComparator, DateTimeZone, Minutes, Seconds}
import org.joda.time.format.{ISODateTimeFormat, DateTimeFormatter, DateTimeFormat}
import scala.util.control.Breaks.{break, breakable}

class Time {
  
  def splitTime() {
    val currentTime: DateTime = new DateTime().withZone(DateTimeZone.UTC)
    
    println(s"Current date time: $currentTime")
    
    val year: Int = currentTime.getYear
    val month: Int = currentTime.getMonthOfYear
    val day: Int = currentTime.getDayOfMonth
    val hour: Int = currentTime.getHourOfDay
    val mins: Int = currentTime.getMinuteOfHour
    val second: Int = currentTime.getSecondOfMinute
    
    val result: List[Int] = List(year, month, day, hour, mins, second)
    println(s"DateTime is splited: $result")//$year -> $month -> $day -> $hour -> $mins -> $second")
  }
  
  def dayOfWeek() {
    val currentTime: DateTime = new DateTime().withZone(DateTimeZone.UTC)
    
    println(s"Current date time: $currentTime")
    
    val year: Int = currentTime.getYear
    val month: Int = currentTime.getMonthOfYear
    val day: Int = currentTime.getDayOfMonth
    
    val tempDate: String = year+"-"+month+"-"+day
    val date: DateTime = new DateTime(tempDate)
    println(s"day of week: ${date.getDayOfWeek.toString}")
    
    println(s"Print day of week: ${currentTime.getDayOfWeek.toString()}")
  }
  
  def timeDifference() {
    val date1: String = "2014-03-12T17:28:19.230Z"
    val date2: String = "2014-03-12T18:28:19.231Z"
    
    val jodaTime1: DateTime = DateTime.parse(date1)
    println(s"String to Joda time: ${jodaTime1.toString()}")
    
    val jodaTime2: DateTime = DateTime.parse(date2)
    println(s"String to Joda time: ${jodaTime2}")
    
    val secondsElapsed: Int = Seconds.secondsBetween(jodaTime1, jodaTime2).getSeconds
    val hours: Double = (secondsElapsed/3600.0)
    val diff: String = BigDecimal(hours).setScale(4, BigDecimal.RoundingMode.HALF_UP).toString()
    
    println(s"Joda time diff: $diff")
  }
  
  def timeFormat() {
    val date1: String = "2014-03-12T17:28:19.230Z"
    val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    val lastDialDate = formatter.parseDateTime(date1)
    println(s"time Format: $lastDialDate")
    
    val localDateTime = new LocalDateTime().toDateTime().withZone(DateTimeZone.UTC)
    println(s"Check Local time: $localDateTime")
    val secondsElapsed: Int = Seconds.secondsBetween(lastDialDate, localDateTime).getSeconds
    val hours: Double = (secondsElapsed/3600.0)
    val diff: String = BigDecimal(hours).setScale(4, BigDecimal.RoundingMode.HALF_UP).toString()
    println(s"The diff to local day time: $diff")
  }

}