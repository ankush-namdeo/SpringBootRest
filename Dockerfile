From java:openjdk-8-jre

ADD target/SpringBootRest-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar" ]

EXPOSE 5000
