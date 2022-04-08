FROM openjdk:11
MAINTAINER Ankita Dutta ankdofficiallyme@gmail.com
ADD target/SPE_Mini_Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar SPE_Mini_Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar
WORKDIR ./
EXPOSE 8081
CMD ["java", "-jar", "SPE_Mini_Calc-1.0-SNAPSHOT-jar-with-dependencies.jar"]