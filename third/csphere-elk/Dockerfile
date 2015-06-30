#
# MAINTAINER        Carson,C.J.Zeong <zcy@nicescale.com>
# DOCKER-VERSION    1.6.2
#
# Dockerizing logstash-forwarder: Dockerfile for building logstash-forwarder images
#
FROM      sebp/elk:latest 
MAINTAINER Carson,C.J.Zeong <zcy@nicescale.com>

COPY logstash-forwarder.key /etc/pki/tls/private/logstash-forwarder.key
COPY logstash-forwarder.crt /etc/pki/tls/certs/logstash-forwarder.crt