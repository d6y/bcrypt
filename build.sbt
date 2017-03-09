organization := "underscore.io"
name := "crypt-example"
version := "1.0.0"
scalaVersion := "2.12.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-language:higherKinds",
  "-Xlint",
  "-Xfatal-warnings",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

libraryDependencies ++= scalatest ++ bcrypt

lazy val scalatest = Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

lazy val bcrypt = Seq(
  "org.mindrot" % "jbcrypt" % "0.4"
)
