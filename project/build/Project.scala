

import sbt._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) with IdeaProject  {
  val scalatoolsRelease = "Scala Tools Snapshot" at
  "http://scala-tools.org/repo-releases/"

  val liftVersion = "2.2"

  lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.7.0"

  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-testkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "com.h2database" % "h2" % "1.2.138",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test->default",
    "ch.qos.logback" % "logback-classic" % "0.9.26",
    "junit" % "junit" % "4.5" % "test->default",
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default",
    "com.github.scala-incubator.io" %% "core" % "0.1.1",
    "com.github.scala-incubator.io" %% "file" % "0.1.1",
    "net.databinder" %% "dispatch-meetup" % "0.7.8",
    "de.element34" % "sbt-eclipsify" % "0.7.0"

  ) ++ super.libraryDependencies
}
