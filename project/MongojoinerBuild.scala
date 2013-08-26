import sbt._
import sbt.Keys._

object Build extends sbt.Build {

  object Dependencies{
    val salat = "com.novus" %% "salat" % "1.9.2"
    val specs2 = "org.specs2" %% "specs2" % "2.1.1" % "test"
    val mockito = "org.mockito" % "mockito-all" % "1.9.5" % "test"
    val all = Seq(salat, specs2, mockito)
  }

  lazy val mongojoiner = Project(
    id = "mongo-joiner",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "mongo-joiner",
      organization := "com.ee",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      libraryDependencies ++= Dependencies.all
    )
  )
}
