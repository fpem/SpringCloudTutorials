# SpringCloudTutorials
This project is a tutorial to build a basic cloud platform with Spring Cloud components including Eureka, Ribbon, Hyxtrix, and Zuul.

To run more instance for any module application, we can build executable jar first, then excute it in command line with parameter like these steps:

cd C:\dev\workspace\mycloud\service-provider

mvn package

java -jar target\service-provider-1.0-SNAPSHOT.jar --server.port=6503
