from ubuntu:14.04

add sources.list /etc/apt/sources.list
run useradd squid && \
    apt-get update && \
    apt-get -y install make g++ perl openssl libssl-dev && \
    apt-get clean

add squid-3.5.5.tar.bz2 /root/
run cd /root/squid-3.5.5 && \
    ./configure --prefix=/usr/local/squid --enable-ssl-crtd \
    --with-openssl --enable-removal-policies="heap,lru" && \
    make && make install && rm -fr /root/squid-3.5.5
workdir /usr/local/squid
run chown -R squid:squid var/*
run mkdir etc/ssl_cert && \
    chown squid:squid etc/ssl_cert && \
    chmod 700 etc/ssl_cert && \
    cd etc/ssl_cert && \
    openssl req -new -newkey rsa:2048 -sha256 -days 3650 -nodes -x509 \
      -subj "/C=CN/ST=Beijing/L=Haidian/O=YunZhan/CN=www.csphere.com" \
      -keyout myCA.pem -out myCA.pem && \
    openssl x509 -in myCA.pem -outform DER -out myCA.der

run ./libexec/ssl_crtd -c -s ./var/cache/ssl_db/ && \
    chown -R squid:squid ./var/cache/ssl_db

add squid.conf /usr/local/squid/etc/squid.conf

volume /usr/local/squid/var/cache/squid
volume /usr/local/squid/var/logs

add start /start
run chmod 755 /start

expose 3128

cmd /start
