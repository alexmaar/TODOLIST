package view

import java.sql.Date

import javafx.scene.control._
import javafx.scene.layout.{GridPane, HBox}
import models.Tables._
import node.TaskItem
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import view.PaneUtils._

import scala.concurrent.ExecutionContext.Implicits.global

class MyPane(db: PostgresProfile.backend.Database) extends GridPane{

  val topHBox = new HBox(10)
  val bottomHBox = new HBox(10)
  val tableView = new TableView[TaskItem]()
  tableView.getSelectionModel.setSelectionMode(SelectionMode.MULTIPLE)

  def addToList(id: Int, task: Option[String], comments: Option[String], deadline: Option[Date], addDate: Option[Date], tableView: TableView[TaskItem]): Unit ={
    comments match{
      case Some(value) => tableView.getItems.add(new TaskItem(id, task.get, value, deadline.get.toString(), addDate.get.toString()))
      case None => tableView.getItems.add(new TaskItem(id, task.get, "", deadline.get.toString(), addDate.get.toString()))
    }
  }
  // get data from database
  db.run(Tasks.result).foreach(taskRows => taskRows.foreach(u => addToList(u.id, u.task, u.comments, u.deadline, u.adddate, tableView)))

  val searchField = new TextField
  searchField.setPromptText("<search>")
  val searchButton = new Button("search")
  val addButton = new Button("add task")
  val deleteButton = new Button("delete task")

  searchButton.setTooltip(new Tooltip("search task"))

  val taskColumn = createTaskColumn()
  val commentsColumn = createCommentsColumn()
  val deadlineColumn = createDeadlineColumn()
  val addDateColumn = createAddDateColumn()

  setTopBoxConf(topHBox, searchField)
  addToTopBox(topHBox, searchField, searchButton)

  addColumns(tableView, taskColumn, commentsColumn, deadlineColumn, addDateColumn)
  tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY)

  setBottomBoxConf(bottomHBox)
  addToBottomBox(bottomHBox, addButton, deleteButton)

  setPaneConfig(this)
  addToPane(this, tableView, topHBox, bottomHBox)
  setColumnConstraints(this)
  setRowConstraints(this)








}
