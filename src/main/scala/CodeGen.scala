package models
import config._
object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    URL,
    "E:/studia/Semestr4/TODOLIST/TODOLIST",
    "models", None, None, false, false
  )
}
