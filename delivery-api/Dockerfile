FROM mysql

EXPOSE 3306
ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes
ADD docker/setup-db.sql /docker-entrypoint-initdb.d/