package actions

import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control.TableView
import node.TaskItem
import view._

class AddTaskEventHandler(tableView: TableView[TaskItem]) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit ={

    val result = UsingUtils.taskEditor("Add new task", new TaskPane)
    result.foreach{task =>
      tableView.getItems.add(task)
      // add to data base ??

    }


  }
}
