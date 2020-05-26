package actions
import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control.TableView
import node.TaskItem
import view._
import slick.jdbc.PostgresProfile.api._
import models.Tables._
import utils._
import slick.jdbc.PostgresProfile


class AddTaskEventHandler(tableView: TableView[TaskItem], db: PostgresProfile.backend.Database) extends EventHandler[ActionEvent] {

  override def handle(event: ActionEvent): Unit ={

    val result = UsingUtils.taskEditor("Add new task", new TaskPane)
    result.foreach{task =>

      val deadline = DateConverter.dateStringToDate(task.getDeadline)
      val today = DateConverter.getTodayAsSqlDate()

      db.run(Tasks+=TasksRow(-1,
        Option(task.getTask),
        Option(task.getComments),
        deadline,
        Option(today)))

      tableView.getItems.add(new TaskItem(-1, task.task, task.comments, task.deadline, today.toString))
    }
  }
}