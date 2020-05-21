package controller
import view._

import actions.{AddTaskEventHandler, DeleteEventHandler, EditTaskEventHandler, SearchEventHandler}

class Controller {

  val pane = new MyPane()
  val searchButton = pane.searchButton
  val searchField = pane.searchField
  val tableView = pane.tableView
  val addButton = pane.addButton
  val deleteButton = pane.deleteButton

  addButton.setOnAction(new AddTaskEventHandler(tableView))
  deleteButton.setOnAction(new DeleteEventHandler(tableView))
  searchButton.setOnAction(new SearchEventHandler(tableView))
  tableView.setOnMouseClicked(new EditTaskEventHandler(tableView))



}
