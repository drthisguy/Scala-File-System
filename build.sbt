import Dependencies._

ThisBuild / name             := "Scala-Filesystem"
ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "1.0.0"
ThisBuild / organization     := "com.drthisguy"
ThisBuild / organizationName := "dirthisguy"

lazy val root = (project in file("."))
  .settings(
    name := "file-system",
    libraryDependencies += scalaTest % Test
  )