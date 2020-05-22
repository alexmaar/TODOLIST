name := "ToDoListProject"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.0.0"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.3.2"
libraryDependencies ++= Seq("org.postgresql" % "postgresql" % "42.2.12")

// https://mvnrepository.com/artifact/org.openjfx/javafx
libraryDependencies += "org.openjfx" % "javafx" % "11" pomOnly()