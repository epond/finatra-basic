name := "finatra-basic"
organization := "com.example"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.7"

fork in run := true

lazy val versions = new {
  val finatra = "2.1.1"
}

libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % versions.finatra)
