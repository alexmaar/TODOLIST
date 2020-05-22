package controller
import view._
import slick.jdbc.PostgresProfile.api._
import config._
import actions.{AddTaskEventHandler, DeleteEventHandler, EditTaskEventHandler, SearchEventHandler}

class Controller {
  // database
  val db = Database.forURL(URL, driver="org.postgresql.Driver")

  val pane = new MyPane(db)
  val searchButton = pane.searchButton
  val searchField = pane.searchField
  val tableView = pane.tableView
  val addButton = pane.addButton
  val deleteButton = pane.deleteButton

  addButton.setOnAction(new AddTaskEventHandler(tableView, db))
  deleteButton.setOnAction(new DeleteEventHandler(tableView, db))
  searchButton.setOnAction(new SearchEventHandler(tableView))
  tableView.setOnMouseClicked(new EditTaskEventHandler(tableView, db))



}
