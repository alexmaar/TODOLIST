package utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.{Calendar, Date}

class DateConverter {

  val format = "EEE, MMM dd, yyyy h:mm a"

  def dateToString(d: LocalDate): String={
    val date = new SimpleDateFormat(format)
    date.format(d)
  }

  def stringToDate(s: String): Date ={
    val string = new SimpleDateFormat(format)
    string.parse(s)
  }

  def currentDate: Date = Calendar.getInstance.getTime

}
