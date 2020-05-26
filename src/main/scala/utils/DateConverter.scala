package utils

import java.text.SimpleDateFormat
import java.util.Calendar


import scala.util.Try

object DateConverter {

  val format = "yyyy-MM-dd"

  def dateStringToDate(date: String) ={
    Try(new SimpleDateFormat(format)
      .parse(date))
      .map(d => new java.sql.Date(d.getTime()))
      .toOption
  }

  def getTodayAsSqlDate() ={
    val calendar = Calendar.getInstance
    val today = new java.sql.Date(calendar.getTime.getTime)
    today
  }

}