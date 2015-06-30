#!/bin/bash

set -e

#
# When Startup Container script
#

if [[ -e /scripts/firstrun ]]; then
	# config mariadb
	/scripts/firstrun_maria
    	rm /scripts/firstrun
else
	# Cleanup previous mariadb sockets
	if [[ -e ${DATA_DIR}/mysql.sock ]]; then
		rm -f ${DATA_DIR}/mysql.sock
	fi
fi

exec /usr/bin/mysqld_safe

