FROM postgres:latest

COPY src/main/resources/schema.sql  /docker-entrypoint-initdb.d/

ENV POSTGRES_DB limit
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD your_password

EXPOSE 5432

