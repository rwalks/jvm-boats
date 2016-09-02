import Keys._

name := "scalaGame"

organization := "com.marqod"

version := "0.0.1"

unmanagedBase <<= baseDirectory { base => base / "lib" }

fork := true

javaOptions += "-Djava.library.path=./lib/native/linux"
