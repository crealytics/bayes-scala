lazy val app = crossProject.
  settings(
    name := "bayes-scala",
    organization := "com.github.danielkorzekwa",
    version := "0.5-SNAPSHOT",
    scalaVersion := "2.10.4",
    unmanagedSourceDirectories in Compile +=
      baseDirectory.value  / "shared" / "main" / "scala",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-encoding", "UTF-8",       // yes, this is 2 args
      "-unchecked",
      "-Xfuture"
      //"-Ywarn-unused-import"     // 2.11 only
    ),
    ScoverageSbtPlugin.ScoverageKeys.coverageHighlighting := false, 
    libraryDependencies ++= Seq(
      "com.googlecode.efficient-java-matrix-library" % "ejml" % "0.20",
      "org.apache.commons" % "commons-math3" % "3.3",
      "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
      "org.scalanlp" %% "breeze" % "0.10",
      // test scoped
      "org.slf4j" % "slf4j-log4j12" % "1.7.2" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test
    )
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.8.0"
    )
  ).jvmSettings(
    libraryDependencies ++= Seq(
      "io.spray" %% "spray-can" % "1.3.2",
      "io.spray" %% "spray-routing" % "1.3.2",
      "com.typesafe.akka" %% "akka-actor" % "2.3.6"
    )
  )

lazy val js = app.js

lazy val jvm = app.jvm
