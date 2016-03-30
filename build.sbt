organization := "com.netaporter"

version := "0.0.8"

scalaVersion := "2.11.5"

crossScalaVersions := Seq(scalaVersion.value, "2.10.4")

name := "pre-canned"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val akka = "2.3.9"
val spray = "1.3.1"

libraryDependencies ++=
  "com.typesafe.akka" %% "akka-actor" % akka ::
  "io.spray" %% "spray-can" % spray ::
  "io.spray" %% "spray-http" % spray ::
  Nil

libraryDependencies ++=
  "io.spray" %% "spray-client" % spray % "test" ::
  "com.typesafe.akka" %% "akka-testkit" % akka % "test" ::
  "org.scalatest" %% "scalatest" % "2.2.4" % "test" ::
  Nil

scalariformSettings

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/net-a-porter/pre-canned</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:net-a-porter/pre-canned.git</url>
      <connection>scm:git@github.com:net-a-porter/pre-canned.git</connection>
    </scm>
    <developers>
      <developer>
        <id>theon</id>
        <name>Ian Forsey</name>
        <url>http://theon.github.io</url>
      </developer>
    </developers>)