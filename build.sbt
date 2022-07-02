import sbt.Keys.libraryDependencies

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = project
  .in (file("."))
//  .configs(IntegrationTest)
  .settings(
    name := "leetcode_scala_java",

      sourceDirectory := baseDirectory.value / "src",
    Compile / scalaSource := sourceDirectory.value /"scala",

    Compile / javaSource := sourceDirectory.value /"javaCode",
    Test / scalaSource := sourceDirectory.value / "test/scala",
    Test / javaSource := sourceDirectory.value / "test/java",


//    Defaults.itSettings,
//    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % "it,test",
//
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12"% Test,
    libraryDependencies += "org.scalatest" %% "scalatest-featurespec" % "3.2.12" % Test
  )


