import scala.util.matching.Regex
val date = raw"(\d{4})-(\d{2})-(\d{2})".r

"2004-01-20" match {
  case date(year, month, day) => s"$year was a good year for PLs."
}

"0000-01-20" match {
  case date(_*) => "It's a date!"
  case _ => "no"
}

val dates = "Important dates in history: 2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15"
val firstDate = date.findFirstIn(dates).getOrElse("No date found.")
val firstYear = for (m <- date.findFirstMatchIn(dates)) yield m.group(2)


val inRange = "\\[[+-]?([0-9]*[.])?[0-9]+,[\\s]?[+-]?([0-9]*[.])?[0-9]+\\]".r

"[2,-3.3]" match {
  case inRange(_*) => "good job"
  case _ => "no way"
}