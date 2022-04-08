FROM openjdk:11
MAINTAINER Ankita Dutta ankdofficiallyme@gmail.com
COPY ./home/ankd/SPE_Mini_Calculator/target/SPE_Mini_Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "SPE_Mini_Calc-1.0-SNAPSHOT-jar-with-dependencies.jar"]