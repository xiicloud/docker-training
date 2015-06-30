#
# MAINTAINER        Carson,C.J.Zeong <zcy@nicescale.com>
# DOCKER-VERSION    1.6.2
#
# Dockerizing logstash-forwarder: Dockerfile for building logstash-forwarder images
#
FROM       csphere/centos:7.1
MAINTAINER Carson,C.J.Zeong <zcy@nicescale.com>

ENV LOGSTASH_FORWARDER_VERSION 0.4.0-1
ENV LOG_DIR /data/logs

RUN yum -y install rsyslog && \
    wget -q https://download.elastic.co/logstash-forwarder/binaries/logstash-forwarder-${LOGSTASH_FORWARDER_VERSION}.x86_64.rpm && \
    yum -y localinstall logstash-forwarder-${LOGSTASH_FORWARDER_VERSION}.x86_64.rpm && \
    mkdir -p /data/logs

COPY logstash-forwarder.conf /etc/logstash-forwarder.conf
COPY logstash-forwarder.crt /etc/pki/tls/certs/logstash-forwarder.crt
COPY supervisor_rsyslog.conf /etc/supervisor.conf.d/rsyslog.conf
COPY supervisor_logstash-forwarder.conf /etc/supervisor.conf.d/logstash-forwarder.conf

VOLUME ["/data/logs"]

EXPOSE 514