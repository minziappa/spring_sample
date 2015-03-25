# The sample for quick start project

By Kim woong joon
kim_woongjoon@cyberagent.co.jp

## About

1. More [information](http://freemarker.org/) about Freemarker.
2. More [information](http://projects.spring.io/spring-framework/) about Spring3.
3. More [information](http://blog.mybatis.org/) about Mybatis3.
4. More [information](https://www.gradle.org/) about Gradle.

* Freemarker
* Spring3-MVC
* Mybatis3
* Gradle

## Requirements environment 

* [Java7](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Tomcat7](http://tomcat.apache.org/download-70.cgi)
* [Maven3](http://maven.apache.org/docs/3.2.2/release-notes.html)

Using your local repositories
```
repositories {
	mavenLocal()
    mavenCentral()
}
```

You have to install on your local system.
```
	compile "io.utility:utility:0.3"
	compile "io.paging:paging:0.1"
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

Run on your local system.
```
gradle jettyRun

This is old ways
Junit Test & compile & make a war file
```
mvn -U clean package -P staging
```
Only skip Junit Test
```
mvn -U clean package -P staging -Dmaven.test.skip=true
```
