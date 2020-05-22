package view

import java.time.LocalDate

import javafx.application.Platform
import javafx.scene.control.ButtonBar.ButtonData
import javafx.scene.control.{ButtonType, Dialog}
import node.TaskItem
import java.time.format.DateTimeFormatter


object UsingUtils {

  def taskEditor(title: String = "Add new task", taskPane: TaskPane): Option[TaskItem] ={

    val addingDialog = new Dialog[Option[TaskItem]]()
    addingDialog.setTitle(title)
    val okButton = new ButtonType("OK", ButtonData.OK_DONE)
    addingDialog.getDialogPane.getButtonTypes.addAll(okButton, ButtonType.CANCEL)
    addingDialog.getDialogPane.setContent(taskPane)
    addingDialog.setResizable(true)

    Platform.runLater(() => taskPane.taskField.requestFocus)

    // OK button handler
    addingDialog.setResultConverter(dialogButton => {
//      if(dialogButton == okButton){
//        val task = new TaskItem(-1, taskPane.taskField.getText,
//          taskPane.commentsField.getText, taskPane.deadlineField.getText, "")
//        Some(task)
//      }

      val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
      val deadline = formatter.format(taskPane.datePicker.getValue)
      println(deadline)

            if(dialogButton == okButton){
              val task = new TaskItem(-1, taskPane.taskField.getText,
                taskPane.commentsField.getText, deadline, "")
              Some(task)
            }

      else{
        None
      }
    })

    val result: Option[TaskItem] = addingDialog.showAndWait().get
    result

  }

}
