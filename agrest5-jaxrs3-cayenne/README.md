# agrest-jaxrs-cayenne

Using [Agrest 4.x](https://agrest.io) with Agrest with JAX-RS 3 API, Apache Cayenne backend and Apache Derby DB.

## Prerequisites:

* Java 17 or newer.
* Apache Maven.

## Run

```
mvn jetty:run
```

Navigate to http://127.0.0.1:8080/api/category 

## Sample Operations

```
curl -i -X POST 'http://127.0.0.1:8080/api/category' \
         -d '{"name":"SciFi","description":"Science Fiction Books"}'
         
curl -i -X GET 'http://127.0.0.1:8080/api/category'
```