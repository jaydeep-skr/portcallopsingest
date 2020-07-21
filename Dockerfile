FROM maven:3.6.3-openjdk-8 as MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean package -DskipTests
FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD ${JAR_FILE} dischargelistingest-0.0.1-SNAPSHOT.jar
RUN mkdir -p /home/AzureUser/portcallopsingest/bin
RUN mkdir -p /home/AzureUser/portcallopsingest/xmldata
COPY --from=MAVEN_BUILD AMPS_discharge_as_XML_OMSLVTM_587_929W.xml  /home/AzureUser/portcallopsingest/xmldata/
COPY --from=MAVEN_BUILD /build/target/dischargelistingest-0.0.1-SNAPSHOT.jar /home/AzureUser/portcallopsingest/bin/
WORKDIR /home/AzureUser/portcallopsingest/bin
ENTRYPOINT ["java","-Dserver.port=8080", "-Dapp.sample.xml.payload=file:/home/AzureUser/portcallopsingest/xmldata/AMPS_discharge_as_XML_OMSLVTM_587_929W.xml","-Dapp.keystore=/usr/local/openjdk-8/jre/lib/security/cacerts","dischargelistingest-0.0.1-SNAPSHOT.jar"]
