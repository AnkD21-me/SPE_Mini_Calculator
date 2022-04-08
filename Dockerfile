FROM openjdk:11
MAINTAINER Ankita Dutta ankdofficiallyme@gmail.com
RUN cp ./target/SPE_Mini_Calc-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "SPE_Mini_Calc-1.0-SNAPSHOT-jar-with-dependencies.jar"]