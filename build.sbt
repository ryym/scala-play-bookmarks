name := """scala-play-bookmarks"""
organization := "org.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "6.0.6",
  "org.scalikejdbc" %% "scalikejdbc" % "3.1.0",
  "org.scalikejdbc" %% "scalikejdbc-config" % "3.1.0",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.6.0",
  "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % "3.1.0",
  "org.mockito" % "mockito-core" % "2.13.0" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.example.binders._"
