name := "Scala SBT Template"

version := "0.1.0"

scalaVersion := "2.10.3"

organization := "com.marqod"

libraryDependencies ++= {
  	Seq(
	  "org.scala-lang" % "scala-swing" % scalaVersion.value
  	)
}

mainClass := Some("com.marqod.rogue.GameApp")

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                )
 
//scalacOptions ++= Seq("-unchecked", "-deprecation")
