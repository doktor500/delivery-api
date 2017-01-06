FROM mysql:8.0.0

ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes
ADD setup-db.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
