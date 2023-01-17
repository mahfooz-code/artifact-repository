# SBT Resolvers Configuration

    resolvers += "Nexus" at "http://localhost:8081/nexus/content/groups/public"

# Credentials in sbt

    credentials += Credentials("Sonatype Nexus Repository Manager", "nexus.scala-tools.org", "admin", "admin123")

# And then used in the publishTo configuration: 

    publishTo <<= version { v: String =>
    val nexus = "http://localhost:8081/nexus/"
    if (v.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
    else
        Some("releases" at nexus + "content/repositories/releases")
        
# Adding repository details
    
    ~/.sbt/repositories 

    [repositories]
    local
    my-ivy-proxy-releases: http://repo.company.com/ivy-releases/, [organization]/[module]/(scala_[scalaVersion]/)(sbt_[sbtVersion]/)[revision]/[type]s/[artifact](-[classifier]).[ext]
    my-maven-proxy-releases: http://repo.company.com/maven-releases/

#  Created a credentials file in ~/.sbt/.credentials

    realm=Artifactory Realm
    host=artifactory.mycompany.com
    user=username
    password=password

# 4) Created a file under ~/.sbt/0.13/plugins/credentials.sbt that wires up the default credentials

    credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

