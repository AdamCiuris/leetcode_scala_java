import sbt.Keys.libraryDependencies

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = project
  .in (file("."))
//  .configs(IntegrationTest)
  .settings(
    name := "leetcode_scala_java",
    scalacOptions ++= Seq("-target:jvm-1.8"),
    javacOptions in (Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8", "-g:lines"),
    sourceDirectory := baseDirectory.value / "src",
    //      Compile / compile / javacOptions ++= Seq("-target", "1.8"),

    Compile / javaSource := sourceDirectory.value /"/javaCode",
    Compile / scalaSource := sourceDirectory.value /"scala",

    Test / scalaSource := sourceDirectory.value / "test/scala",
    Test / javaSource := sourceDirectory.value / "test/java",
//    mainClass in (Compile, packageBin) := Some(sourceDirectory.value),
//    mainClass in (Compile, run) := Some(javaSource.value + "/Mingo"),
//    compile / javacOptions ++= Seq("-Xlint", "-Xlint:-serial"),
//    Defaults.itSettings,
//    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % "it,test",
//
    compileOrder := CompileOrder.JavaThenScala,
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.12"% Test,
     "org.scalatest" %% "scalatest-featurespec" % "3.2.12" % Test

    )
  )


