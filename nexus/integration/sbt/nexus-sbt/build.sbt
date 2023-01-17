ThisBuild / organization := "com.mahfooz.nexus"
ThisBuild / organizationName := "mahfooz-code"
ThisBuild / organizationHomepage := Some(url("http://example.com/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/your-account/your-project"),
    "scm:git@github.com:your-account/your-project.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id    = "mahfooz.iiitian",
    name  = "Mohammad Mahfooz Alam",
    email = "mahfooz.iiitian@gmail.com",
    url   = url("http://your.url")
  )
)

ThisBuild / description := "Some description about your project."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/example/project"))

//This is not working
credentials += Credentials(Path.userHome/".sbt"/".credentials")

//This is working
credentials += Credentials("Sonatype Nexus Repository Manager",
                           "localhost",
                           "admin",
                           "nexus_admin")

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "http://localhost:8081/nexus/"
  if (isSnapshot.value) Some("snapshots" at nexus + "repository/ivy-snapshots/")
  else Some("releases" at nexus + "repository/ivy-releases/")
}
ThisBuild / publishMavenStyle := true