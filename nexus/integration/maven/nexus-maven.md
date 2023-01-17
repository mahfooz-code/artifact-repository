# snapshots repo
A repository for Maven artifacts that you deploy with -SNAPSHOT in the end of the version tag of your pom.xml:

    <version>1.0.0-SNAPSHOT</version>


# releases repo

A repository for Maven artifact that you deploy without -SNAPSHOT in the end of the version tag of your pom.xml:

    <version>1.0.0</version>


# proxy to Maven Central repo

# group repo

This will group all the above repos and provide you a single URL to configure your clients to download from/deploy to.


# Configuring your clients and projects to use your Nexus repos

Put this in your ~/.m2/settings.xml file.

    <?xml version="1.0" encoding="UTF-8"?>
    <settings xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">

    <servers>
        <server>
            <id>nexus-snapshots</id>
            <username>admin</username>
            <password>admin123</password>
        </server>
        <server>
            <id>nexus-releases</id>
            <username>admin</username>
            <password>admin123</password>
        </server>
    </servers>

    <mirrors>
        <mirror>
            <id>central</id>
            <name>central</name>
            <url>http://your-host:8081/repository/maven-group/</url>
            <mirrorOf>*</mirrorOf>
        </mirror>
    </mirrors>

    </settings>

# If you want only to download dependencies from Nexus, put this in the pom.xml:

    <repositories>
        <repository>
            <id>maven-group</id>
            <url>http://your-host:8081/repository/maven-group/</url>
        </repository>
    </repositories>


# And if you want also to publish your project

    <distributionManagement>
        <snapshotRepository>
        <id>nexus-snapshots</id>
        <url>http://your-host:8081/repository/maven-snapshots/</url>
        </snapshotRepository>
        <repository>
        <id>nexus-releases</id>
        <url>http://your-host:8081/repository/maven-releases/</url>
        </repository>
    </distributionManagement>
    </project>