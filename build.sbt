name := "Scala-Practice"

version := "0.1"

scalaVersion := "2.11.7"
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % Test,
  "org.scalatest" %% "scalatest" % "2.2.6" % Test,
  "org.scalacheck" %% "scalacheck" % "1.12.5" % Test
)

// scala.reflect.internal.MissingRequirementError: object java.lang.Object in compiler mirror not found. → https://stackoverflow.com/a/39795029/11521880