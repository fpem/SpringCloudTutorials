# SpringCloudTutorials
Spring Cloud Tutorials including Eureka, Ribbon, Hyxtrix, and Zuul

TO run more than one instance of any module application,
please build executable jar first and then excute command with parameter like these steps:

cd C:\dev\workspace\mycloud\service-provider
mvn package

java -jar target\service-provider-1.0-SNAPSHOT.jar --server.port=6503
