FROM java:8
VOLUME /tmp
ADD ["spring-boot-docker-1.0-SNAPSHOT.jar","spring-boot-docker.jar"]
EXPOSE :8080
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]