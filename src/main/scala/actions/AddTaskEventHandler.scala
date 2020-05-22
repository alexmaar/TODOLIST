package actions

import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control.TableView
import node.TaskItem
import view._
import slick.jdbc.PostgresProfile.api._
import models.Tables._
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

import slick.jdbc.PostgresProfile

import scala.util.Try

class AddTaskEventHandler(tableView: TableView[TaskItem], db: PostgresProfile.backend.Database) extends EventHandler[ActionEvent] {

  override def handle(event: ActionEvent): Unit ={

    val result = UsingUtils.taskEditor("Add new task", new TaskPane)
    result.foreach{task =>

      val deadline = Try(new SimpleDateFormat("yyyy-MM-dd").parse(task.getDeadline))
        .map(d => new java.sql.Date(d.getTime()))
        .toOption

      val calendar = Calendar.getInstance
      val today = new java.sql.Date(calendar.getTime.getTime)

      db.run(Tasks+=TasksRow(-1, Option(task.getTask),Option(task.getComments), deadline, Option(today)))

      tableView.getItems.add(new TaskItem(-1, task.task, task.comments, task.deadline, today.toString))
    }
  }
}
