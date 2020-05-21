package view

import javafx.geometry.{HPos, Insets, VPos}
import javafx.scene.control._
import javafx.scene.layout.{ColumnConstraints, GridPane, Priority}

class TaskPane extends GridPane {

  val taskLabel = new Label("Note:")
  val commentsLabel = new Label("Comments:")
  val deadlineLabel = new Label("Deadline date:")
  val addingDateLabel = new Label("Adding date:")

  val taskField = new TextArea()
  val commentsField = new TextArea()
  val deadlineField = new TextArea()
  val addingDateField = new TextArea()

  val saveButton = new Button("Save")
  val cancelButton = new Button("Cancel")

  taskField.setWrapText(true)
  GridPane.setVgrow(taskField, Priority.ALWAYS)
  commentsField.setPromptText("optional")

  this.addRow(0, taskLabel, taskField)
  this.addRow(1, commentsLabel, commentsField)
  this.addRow(2, addingDateLabel, addingDateField)
  this.addRow(3, deadlineLabel, deadlineField)

  GridPane.setValignment(taskLabel, VPos.TOP)
  GridPane.setHalignment(taskLabel, HPos.RIGHT)
  GridPane.setHalignment(commentsField, HPos.RIGHT)
  GridPane.setHalignment(addingDateField, HPos.RIGHT)
  GridPane.setHalignment(deadlineField, HPos.RIGHT)

  val col1 = new ColumnConstraints()
  col1.setPercentWidth(25)
  val col2 = new ColumnConstraints()
  col2.setPercentWidth(75)
  this.getColumnConstraints.addAll(col1,col2)
  this.setPadding(new Insets(10))
  this.setHgap(8)
  this.setVgap(8)
  this.setMinWidth(600)
  this.setPrefWidth(600)
  this.setPrefHeight(500)
  this.setMinHeight(500)
  taskField.setPrefRowCount(10)
  taskField.setPrefColumnCount(80)



}
