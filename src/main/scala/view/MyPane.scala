package view

import javafx.scene.control._
import javafx.scene.layout.{GridPane, HBox}
import node.TaskItem
import view.PaneUtils._

class MyPane extends GridPane{

  val topHBox = new HBox(10)
  val bottomHBox = new HBox(10)

  val tableView = new TableView[TaskItem]()
  tableView.getSelectionModel.setSelectionMode(SelectionMode.MULTIPLE)

  val searchField = new TextField
  searchField.setPromptText("<search>")
  val searchButton = new Button("search")
  val addButton = new Button("add task")
  val deleteButton = new Button("delete task")

  searchButton.setTooltip(new Tooltip("search task"))

  val taskColumn = createTaskColumn()
  val commentsColumn = createCommentsColumn()
  val deadlineColumn = createDeadlineColumn()

  setTopBoxConf(topHBox, searchField)
  addToTopBox(topHBox, searchField, searchButton)

  addColumns(tableView, taskColumn, commentsColumn, deadlineColumn)
  tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY)

  setBottomBoxConf(bottomHBox)
  addToBottomBox(bottomHBox, addButton, deleteButton)

  setPaneConfig(this)
  addToPane(this, tableView, topHBox, bottomHBox)
  setColumnConstraints(this)
  setRowConstraints(this)








}
