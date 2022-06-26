# Apache TomEE Jakarta AngularJS Arquillian Starter Project

[![Try it out in Codenvy](https://tomitribe.github.io/codenvy/tryitout.svg)](https://codenvy.com/f?id=dztffm6dfrw4s3ld)

Starter project created with Netbeans IDE v13 and tested using TomEE 9.0 and Java EE version Jakarta EE 9 Web.

This starter project contains:

1- Base Jakarta JAXRS Configuration
 -- src/main/java/org/lcdevelop/web/JAXRSApplication

With this base configuration de base API is:
 http://localhost:8080/jakarta-tomee-angular-arquillian-starter/api

2- Java base classes for demostration
 -- src/main/java/org/lcdevelop/entity/Sample.java
 -- src/main/java/org/lcdevelop/web/SampleResource.java
 -- src/test/java/org/lcdevelop/web/SampleResourceTest.java
 -- src/main/java/org/lcdevelop/web/RestGenericParser.java

3- Angular and javascript base classes for demostration
 -- webjars/angularjs/1.8.2/angular.js (Maven dependency)
 -- src/main/webapp/resources/static/js/controllers.js

4- Bootstrap and CSS base classes for demostration
 -- webjars/bootstrap/5.1.3/css/bootstrap.css (Maven dependency)
 -- src/main/webapp/resources/static/css/app.css
