FROM adoptopenjdk/openjdk11:alpine
COPY target/StudienprojektKneisel-1.0.0.jar StudienprojektKneisel-1.0.0.jar
ENTRYPOINT ["java","-jar","/StudienprojektKneisel-1.0.0.jar"]