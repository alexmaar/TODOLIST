package actions

import javafx.event.EventHandler
import javafx.scene.control.TableView
import javafx.scene.input.MouseEvent
import node.TaskItem
import view._

class EditTaskEventHandler(tableView: TableView[TaskItem]) extends EventHandler[MouseEvent] {
  override def handle(e: MouseEvent): Unit ={

    if(e.getClickCount() > 1 && tableView.getSelectionModel().getSelectedItem() != null){

      val editedTaskPane = new TaskPane
      val originalTask = tableView.getSelectionModel.getSelectedItem
      val originalTaskIdx = tableView.getSelectionModel.selectedIndexProperty().get

      editedTaskPane.taskField.setText(originalTask.task)
      editedTaskPane.commentsField.setText(originalTask.comments)
      editedTaskPane.deadlineField.setText(originalTask.deadline) // TO DO convert date

      val result = UsingUtils.taskEditor("Edit task",editedTaskPane)
      // show window and wait for ok/cancel button
      result match{
        case Some(editedTask) =>
        //delete from data base old task
        // add to data base new task
          tableView.getItems.set(originalTaskIdx, editedTask) // set on the same index
      }
    }
  }

}
