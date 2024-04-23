import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val commonClasses = (project in file("platform/common-classes"))
  .settings(
    name := "Common Classes",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )

lazy val domainA = (project in file("subdomains/domain-A"))
  .settings(
    name := "Domain A",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses)

lazy val utils = (project in file("subdomains/utils"))
  .settings(
    name := "Utils",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
  )

lazy val subdomain1 = (project in file("subdomains/subdomain1"))
  .settings(
    name := "Subdomain 1",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses, utils)

lazy val subdomain2 = (project in file("subdomains/subdomain2"))
  .settings(
    name := "Subdomain 2",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses)

lazy val subdomain3 = (project in file("subdomains/subdomain3"))
  .settings(
    name := "Subdomain 3",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses)

lazy val subdomain4 = (project in file("subdomains/subdomain4"))
  .settings(
    name := "Subdomain 4",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses)

lazy val root = (project in file("."))
  .aggregate(commonClasses, domainA, subdomain1, subdomain2, subdomain3, subdomain4, utils)
  .dependsOn(commonClasses, subdomain1, subdomain2, subdomain3, subdomain4)
  .settings(
    name := "Testing Devin Code Migrations Scala",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided,
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
