FROM postgres:latest

COPY src/main/resources/schema.sql  /docker-entrypoint-initdb.d/

ENV POSTGRES_DB limit
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD your_password

EXPOSE 5432

#  docker build --no-cache -f Dockerfile -t limit/postgres:latest .
# docker run -p 5432:5432 -e POSTGRES_PASSWORD=your_password postgres:latest