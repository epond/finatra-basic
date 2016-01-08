name := "finatra-basic"
organization := "com.example"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.7"

fork in run := true

javaOptions ++= Seq(
  "-Dlog.service.output=/dev/stderr",
  "-Dlog.access.output=/dev/stderr")

lazy val versions = new {
  val finatra = "2.1.1"
  val logback = "1.0.13"
}

libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % versions.finatra,
  "com.twitter.finatra" %% "finatra-slf4j" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback)
