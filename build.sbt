import scala.collection.Seq

performMavenCentralSync in ThisBuild := false   // basically just ignores all the sonatype sync parts of things

publishAsOSSProject in ThisBuild := true

homepage in ThisBuild := Some(url("https://github.com/slamdata/sbt-quasar-datasource"))

scmInfo in ThisBuild := Some(ScmInfo(
  url("https://github.com/slamdata/sbt-quasar-datasource"),
  "scm:git@github.com:slamdata/sbt-quasar-datasource.git"))

lazy val root = project
  .in(file("."))
  .settings(name := "sbt-quasar-datasource")
  .settings(libraryDependencies ++= Seq(
    "io.circe" %% "circe-core" % "0.10.1",
    "io.get-coursier" %% "coursier" % "1.1.0-M7",
    "io.get-coursier" %% "coursier-cache" % "1.1.0-M7",
    // FIXME{coursier}: Align all versions once sbt-coursier-1.1.0-M8 is released
    "io.get-coursier" %% "coursier-cats-interop" % "1.1.0-M8"
  ))
  .enablePlugins(SbtPlugin, AutomateHeaderPlugin)
