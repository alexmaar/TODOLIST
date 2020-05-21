package actions


import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control.TableView
import node.TaskItem

class SearchEventHandler(tableView: TableView[TaskItem]) extends EventHandler[ActionEvent] {
  override def handle(e: ActionEvent): Unit ={

    //TODO
  }

}
