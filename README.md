# The sample for quick start project

[![Build Status](https://travis-ci.org/minziappa/spring_sample.svg?branch=master)](https://travis-ci.org/minziappa/spring_sample.svg)

By Kim joon

## About
* More [information](http://freemarker.org) about Freemarker.
* More [information](http://projects.spring.io/spring-framework) about Spring4.
* More [information](http://blog.mybatis.org) about Mybatis3
* More [information](https://www.gradle.org) about Gradle.

## Requirements environment 

* [Java7](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven3](http://maven.apache.org/docs/3.2.2/release-notes.html)
* [Gradle](https://services.gradle.org/distributions/gradle-2.3-all.zip)

Using your local repositories
```
repositories {
   mavenCentral()
   mavenLocal()
}
```

You have to install on your local system.
```
compile "io.utility:utility:0.5"
compile "io.paging:paging:0.1"
```
[utility](https://github.com/minziappa/utility)
[paging](https://github.com/minziappa/paging)

## Get started

Make the database
```
document/make_table.ddl
document/make_data.ddl
```
Make an account on mysql
```
GRANT ALL PRIVILEGES ON sample_db.* TO admin@localhost IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON sample_db.* TO admin@'172.0.%' IDENTIFIED BY 'password';
FLUSH PRIVILEGES;
```
Change a project name like the following:
```
sample -> project name
```

## Deploy
Run this on your local system.
```
gradle jettyRun
```

Maven
Junit Test & compile & make a war file
```
mvn -U clean package -P staging
```
Only skip Junit Test
```
mvn -U clean package -P staging -Dmaven.test.skip=true
```
