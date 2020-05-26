package actions

import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control.TableView
import node.TaskItem
import controller._
import slick.jdbc.PostgresProfile


class SearchEventHandler(controller: Controller, db: PostgresProfile.backend.Database, tableView: TableView[TaskItem]) extends EventHandler[ActionEvent] {
  override def handle(e: ActionEvent): Unit ={

    val textToSearch = controller.searchField.getText.trim.toLowerCase()

    tableView
      .getItems
      .stream()
      .filter(item =>
        (item.task.toLowerCase().contains(textToSearch) ||
      item.comments.toLowerCase().contains(textToSearch) || item.deadline.toLowerCase.contains(textToSearch)))
      .findAny()
      .ifPresent(item
      => {
        tableView
          .getSelectionModel
          .select(item)
        tableView
          .scrollTo(item)})


  }

}