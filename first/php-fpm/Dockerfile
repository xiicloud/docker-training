#
# MAINTAINER        Carson,C.J.Zeong <zcy@nicescale.com>
# DOCKER-VERSION    1.6.2
#
# Dockerizing php-fpm: Dockerfile for building php-fpm images
#
FROM       csphere/centos:7.1
MAINTAINER Carson,C.J.Zeong <zcy@nicescale.com>

# Set environment variable
ENV	APP_DIR /app

RUN	yum -y install nginx php-cli php-mysql php-pear php-ldap php-mbstring php-soap php-dom php-gd php-xmlrpc php-fpm php-mcrypt && \ 
	yum clean all

ADD nginx_nginx.conf /etc/nginx/nginx.conf
ADD	nginx_default.conf /etc/nginx/conf.d/default.conf

ADD	php_www.conf /etc/php-fpm.d/www.conf
RUN	sed -i 's/;cgi.fix_pathinfo=1/cgi.fix_pathinfo=0/' /etc/php.ini

RUN	mkdir -p /app && echo "<?php phpinfo(); ?>" > ${APP_DIR}/info.php

EXPOSE	80 443

ADD	supervisor_nginx.conf /etc/supervisor.conf.d/nginx.conf
ADD	supervisor_php-fpm.conf /etc/supervisor.conf.d/php-fpm.conf

ONBUILD ADD . /app
ONBUILD RUN chown -R nginx:nginx /app
