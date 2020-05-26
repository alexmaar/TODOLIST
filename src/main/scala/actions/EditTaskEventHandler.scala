package actions

import java.text.SimpleDateFormat
import java.util.Calendar

import javafx.event.EventHandler
import javafx.scene.control.TableView
import javafx.scene.input.MouseEvent
import node.TaskItem
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import view._
import models.Tables._
import utils._

class EditTaskEventHandler(tableView: TableView[TaskItem], db: PostgresProfile.backend.Database) extends EventHandler[MouseEvent] {
  override def handle(e: MouseEvent): Unit ={

    if(e.getClickCount() > 1 && tableView.getSelectionModel().getSelectedItem() != null){

      val editedTaskPane = new TaskPane
      val originalTask = tableView.getSelectionModel.getSelectedItem
      val originalTaskIdx = tableView.getSelectionModel.selectedIndexProperty().get

      editedTaskPane.taskField.setText(originalTask.task)
      editedTaskPane.commentsField.setText(originalTask.comments)
      editedTaskPane.deadlineField.setText(originalTask.deadline)

      val result = UsingUtils.taskEditor("Edit task",editedTaskPane)
      // show window and wait for ok/cancel button
      result match{
        case Some(editedTask) =>

          val newDeadline = DateConverter.dateStringToDate(editedTask.getDeadline)
          val today = DateConverter.getTodayAsSqlDate()

          // edit task in database
          db.run(Tasks.filter(_.task === originalTask.task)
            .map(t => (t.task, t.comments, t.deadline, t.adddate))
            .update((Option(editedTask.task)), Option(editedTask.comments), newDeadline, Option(today)))

          // edit task in table view
          tableView.getItems.set(originalTaskIdx,
            new TaskItem(originalTaskIdx, editedTask.task, editedTask.comments, editedTask.deadline, today.toString)) // set on the same index
      }
    }
  }

}