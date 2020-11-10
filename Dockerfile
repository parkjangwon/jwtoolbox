FROM java:8
MAINTAINER Jangwon Park <vim@kakao.com>

VOLUME /tmp

EXPOSE 8080

ADD target/jwtoolbox-demo.jar jwtoolbox-demo.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","jwtoolbox-demo.jar"]