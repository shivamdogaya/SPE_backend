FROM openjdk
EXPOSE 8001
WORKDIR ./
COPY ./target/1-onlineExamSystem-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "1-onlineExamSystem-0.0.1-SNAPSHOT.jar"]