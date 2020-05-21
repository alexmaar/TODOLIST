package view

import javafx.geometry.{Insets, Pos}
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.{Button, TableColumn, TableView, TextField}
import javafx.scene.layout.{ColumnConstraints, HBox, Priority, RowConstraints}
import node.TaskItem

object PaneUtils {

  def createTaskColumn(): TableColumn[TaskItem, String] ={
    val taskColumn = new TableColumn[TaskItem, String]("Task")
    taskColumn.setMinWidth(250)
    taskColumn.setCellValueFactory(new PropertyValueFactory[TaskItem, String]("Task"))
    taskColumn
  }

  def createCommentsColumn(): TableColumn[TaskItem, String]={
  val commentsColumn = new TableColumn[TaskItem, String]("Comments")
    commentsColumn.setMinWidth(150)
    commentsColumn.setCellValueFactory(new PropertyValueFactory[TaskItem, String]("Comments"))
    commentsColumn
  }

  def createDeadlineColumn(): TableColumn[TaskItem, String]={
    val deadlineColumn = new TableColumn[TaskItem, String]("Deadline")
    deadlineColumn.setMinWidth(150)
    deadlineColumn.setCellValueFactory(new PropertyValueFactory[TaskItem, String]("Deadline"))
    deadlineColumn
  }

  def setTopBoxConf(box: HBox, searchField: TextField): Unit ={
    searchField.setPrefWidth(400)
    HBox.setHgrow(searchField, Priority.ALWAYS)
    HBox.setHgrow(box, Priority.ALWAYS)
  }

  def addToTopBox(box: HBox, searchField: TextField, searchButton: Button): Unit ={
    box.getChildren.addAll(searchField, searchButton)
  }

  def setBottomBoxConf(box: HBox): Unit ={
    box.setAlignment(Pos.BASELINE_CENTER)
    HBox.setHgrow(box, Priority.ALWAYS)
  }

  def addToBottomBox(box: HBox, addButton: Button, deleteButton: Button): Unit ={
    box.getChildren.addAll(addButton, deleteButton)
  }

  def setPaneConfig(pane: MyPane): Unit ={
    pane.setPadding(new Insets(10))
    pane.setHgap(10)
    pane.setVgap(10)
  }

  def addToPane(pane: MyPane, tableView: TableView[TaskItem], topBox: HBox, bottomBox: HBox): Unit ={
    pane.add(topBox, 0, 0)
    pane.add(tableView, 0, 1)
    pane.add(bottomBox, 0, 2)
  }

  def addColumns(tableView: TableView[TaskItem], taskColumn: TableColumn[TaskItem, String],
                 commentsColumn: TableColumn[TaskItem, String],
                 deadlineColumn: TableColumn[TaskItem, String]): Unit ={
    tableView.getColumns.addAll(taskColumn, commentsColumn, deadlineColumn)
  }

  def setColumnConstraints(gridPane: MyPane): Unit = {
    val col = new ColumnConstraints
    col.setPercentWidth(100)
    gridPane.getColumnConstraints.addAll(col)
  }

  def setRowConstraints(gridPane: MyPane): Unit = {
    val upConst= new RowConstraints;
    upConst.setVgrow(Priority.ALWAYS)
    val botConst = new RowConstraints;
    botConst.setVgrow(Priority.NEVER)

    gridPane.getRowConstraints.addAll(upConst, botConst)
  }



}
