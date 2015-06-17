#
# MAINTAINER        Carson,C.J.Zeong <zcy@nicescale.com>
# DOCKER-VERSION    1.6.2
#
# Dockerizing HelloWorld: Dockerfile for building HelloWorld images
#
FROM       csphere/tomcat:7.0.55
MAINTAINER Carson,C.J.Zeong <zcy@nicescale.com>

ADD init /init

ENTRYPOINT ["/init", "/scripts/run"]
