#
# MAINTAINER        Carson,C.J.Zeong <zcy@nicescale.com>
# DOCKER-VERSION    1.6.2
#
# Dockerizing maven: Dockerfile for building maven images
#
FROM       csphere/jdk:1.7.0
MAINTAINER Carson,C.J.Zeong <zcy@nicescale.com>

ENV MAVEN_VERSION 3.3.3
ENV MAVEN_HOME /opt/maven

# Install maven
# RUN curl -fsSL http://mirror.cc.columbia.edu/pub/software/apache/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz

COPY apache-maven-3.3.3-bin.tar.gz /opt/

RUN tar xzf /opt/apache-maven-3.3.3-bin.tar.gz -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven  && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

COPY settings.xml /opt/maven/conf/settings.xml

ADD hello /hello
RUN cd /hello && \
    mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true