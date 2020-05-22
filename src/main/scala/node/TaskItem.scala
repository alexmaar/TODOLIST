package node

class TaskItem(val id: Int, val task: String, val comments: String, val deadline: String, val addDate: String) {

  def getId: Int = id
  def getTask: String = task
  def getComments: String = comments
  def getDeadline: String = deadline
  def getAddDate: String = addDate



}
