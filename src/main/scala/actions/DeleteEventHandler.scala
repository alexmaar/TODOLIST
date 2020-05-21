package actions

import java.util.Optional

import javafx.collections.ObservableList
import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.{Alert, ButtonType, TableView}
import node.TaskItem

class DeleteEventHandler(tableView: TableView[TaskItem]) extends EventHandler[ActionEvent]{
  override def handle(event: ActionEvent): Unit ={

    // chosen items as observableList
    val tableViewItems: ObservableList[TaskItem] = tableView.getSelectionModel.getSelectedItems


    if(tableViewItems.size() > 0){
      val alert = new Alert(AlertType.CONFIRMATION)
      if(tableViewItems.size == 1){
        alert.setTitle("Delete task?")
        alert.setContentText("Delete the selected task?")
      }
      else{
        alert.setTitle("Delete tasks?")
        alert.setContentText("Delete the selected tasks?")
      }
      // show window and wait for ok/cancel button
      val result:Optional[ButtonType] = alert.showAndWait
      if(result.get() == ButtonType.OK){
        // delete from data base(tableViewItems)

        tableView.getItems.removeAll(tableViewItems) // delete chosen items from tableView
        tableView.getSelectionModel.clearSelection()
      }
    }



    }
  }
