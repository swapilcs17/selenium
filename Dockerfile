FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /target

ADD target/selenium-docker.jar selenium-docker.jar

ADD target/selenium-docker-tests.jar selenium-docker-tests.jar

ADD target/libs libs

ADD target/src/test/resources/project.properties src/test/resources/project.properties

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -Dcucumber.options=classpath:features org.junit.runner.JUnitCore com.qtpselenium.runner.TestRunner

