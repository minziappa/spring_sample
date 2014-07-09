# A sample for quick start a project

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

* Java7
* Tomcat7
* Maven3
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
          <url>http://172.28.238.69:8081/artifactory/libs-releases</url>
        </repository>
        <repository>
          <id>snapshots</id>
          <name>libs-snapshots</name>
          <url>http://172.28.238.69:8081/artifactory/libs-snapshots</url>
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

## Get started

Change the path of Log like the following:
```
/Users/[user account]/tomcat/logs/sample.log
```
Change name like the following:
```
sample -> project name
```

## Deploy
```
mvn -U package -p staging
```