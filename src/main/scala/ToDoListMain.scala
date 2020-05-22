import controller.Controller
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.{Screen, Stage}
import node.TaskItem

object ToDoListMain{
  def main(args: Array[String]): Unit ={
    Application.launch(classOf[ToDoListMain], args: _*)
  }
}

class ToDoListMain extends Application{

   def Height() = Screen.getPrimary.getVisualBounds.getHeight *2/3
   def Width() = Screen.getPrimary.getVisualBounds.getHeight *2/3

   val controller = new Controller

   def start(mainStage: Stage): Unit ={
     val myPane = controller.pane
     val myScene = new Scene(myPane,Height, Width)
     myScene.getStylesheets.add(getClass.getResource("styles/notes.css").toExternalForm)

     mainStage.setTitle("TO DO LIST")
     mainStage.setScene(myScene)
     mainStage.sizeToScene()
     mainStage.show
   }

}
