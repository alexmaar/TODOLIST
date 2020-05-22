package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Tasks.schema ++ Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Tasks
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param task Database column task SqlType(varchar), Length(500,true), Default(None)
   *  @param comments Database column comments SqlType(varchar), Length(500,true), Default(None)
   *  @param deadline Database column deadline SqlType(date), Default(None)
   *  @param adddate Database column addDate SqlType(date), Default(None) */
  case class TasksRow(id: Int, task: Option[String] = None, comments: Option[String] = None, deadline: Option[java.sql.Date] = None, adddate: Option[java.sql.Date] = None)
  /** GetResult implicit for fetching TasksRow objects using plain SQL queries */
  implicit def GetResultTasksRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[java.sql.Date]]): GR[TasksRow] = GR{
    prs => import prs._
    TasksRow.tupled((<<[Int], <<?[String], <<?[String], <<?[java.sql.Date], <<?[java.sql.Date]))
  }
  /** Table description of table tasks. Objects of this class serve as prototypes for rows in queries. */
  class Tasks(_tableTag: Tag) extends profile.api.Table[TasksRow](_tableTag, "tasks") {
    def * = (id, task, comments, deadline, adddate) <> (TasksRow.tupled, TasksRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), task, comments, deadline, adddate)).shaped.<>({r=>import r._; _1.map(_=> TasksRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column task SqlType(varchar), Length(500,true), Default(None) */
    val task: Rep[Option[String]] = column[Option[String]]("task", O.Length(500,varying=true), O.Default(None))
    /** Database column comments SqlType(varchar), Length(500,true), Default(None) */
    val comments: Rep[Option[String]] = column[Option[String]]("comments", O.Length(500,varying=true), O.Default(None))
    /** Database column deadline SqlType(date), Default(None) */
    val deadline: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("deadline", O.Default(None))
    /** Database column addDate SqlType(date), Default(None) */
    val adddate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("addDate", O.Default(None))
  }
  /** Collection-like TableQuery object for table Tasks */
  lazy val Tasks = new TableQuery(tag => new Tasks(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param email Database column email SqlType(varchar), Length(20,true)
   *  @param password Database column password SqlType(varchar), Length(200,true) */
  case class UsersRow(id: Int, email: String, password: String)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, "users") {
    def * = (id, email, password) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(email), Rep.Some(password))).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email SqlType(varchar), Length(20,true) */
    val email: Rep[String] = column[String]("email", O.Length(20,varying=true))
    /** Database column password SqlType(varchar), Length(200,true) */
    val password: Rep[String] = column[String]("password", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
