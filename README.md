# The sample for quick start project

By Kim woong joon
kim_woongjoon@cyberagent.co.jp

## About

1. More [information](http://freemarker.org/) about Freemarker.
2. More [information](http://projects.spring.io/spring-framework/) about Spring3.
3. More [information](http://blog.mybatis.org/) about Mybatis3.

* Freemarker
* Spring3-MVC
* Mybatis3

## Requirements environment 

* [Java7](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Tomcat7](http://tomcat.apache.org/download-70.cgi)
* [Maven3](http://maven.apache.org/docs/3.2.2/release-notes.html)

Create the settings.xml and Settings Details
/Users/kim_woongjoon/.m2/settings.xml
Change the loccalhost for the server IP address.
```
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <servers>
    <server>
      <id>stg-common-mvn01</id>
      <username>admin</username>
      <password>password</password>
    </server>
  </servers>
  <profiles>
    <profile>
      <repositories>
        <repository>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
          <id>central</id>
          <name>libs-releases</name>
          <url>http://localhost:8081/artifactory/libs-releases</url>
        </repository>
        <repository>
          <id>snapshots</id>
          <name>libs-snapshots</name>
          <url>http://localhost:8081/artifactory/libs-snapshots</url>
        </repository>
        <repository>
            <id>maven3-repository.dev.java.net</id>
            <name>Java.net Repository for Maven</name>
            <url>http://download.java.net/maven/3/</url>
            <layout>default</layout>
        </repository>
      </repositories>
      <id>artifactory</id>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>artifactory</activeProfile>
  </activeProfiles>
</settings>
```

If you like to use a private repository, you have to set like the following. 
Change the loccalhost for the server IP address.
```
	<repositories>
		<repository>
			<id>public</id>
			<name>Internal Repository</name>
			<url>http://localhost:8081/nexus/content/groups/public/</url>
		</repository>
		<repository>
			<id>stg-common-mvn01</id>
			<name>stg-common-mvn01-releases</name>
			<url>http://localhost1:8081/artifactory/libs-releases-local</url>
		</repository>
	</repositories>

 	<distributionManagement>
		<repository>
			<id>releases</id>
			<name>Internal Release Repository</name>
			<url>http://localhost:8081/nexus/content/repositories/releases</url>
		</repository>
		<snapshotRepository>
			<id>snapshots</id>
			<name>Internal Snapshot Repository</name>
			<url>http://localhost:8081/nexus/content/repositories/snapshots</url>
		</snapshotRepository>
	</distributionManagement>
```

## Get started

Change the path of Log like the following:
```
/Users/[user account]/tomcat/logs/sample.log
```
Change a project name like the following:
```
sample -> project name
```

## Deploy
Junit Test & compile & make a war file
```
mvn -U clean package -P staging
```
Only skip Junit Test
```
mvn -U clean package -P staging -Dmaven.test.skip=true
```
