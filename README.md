# Purpose

Purpose of the project is to create simple URL shortener service to use as mock in testing environment.

# Requirements

* Java - JDK 11 or later (https://adoptopenjdk.net/)
* Maven 3.2 or later (https://maven.apache.org/download.cgi)

## Runing project

To run project simple exec this command in working directory:

```
./mvnw spring-boot:run
```

# URLs

* GET / - service status
* POST /short - create short url
* GET /v/{hash} - redirect to shortened url

## Create short URL
```
http --pretty format --form post http://127.0.0.1:8080/short url=http://www.to.jest.dlugi.adres/ala-ma.kota/test.html
```

```
HTTP/1.1 200 
Connection: keep-alive
Content-Length: 56
Content-Type: text/plain;charset=UTF-8
Date: Sun, 28 Feb 2021 11:47:56 GMT
Keep-Alive: timeout=60

http://127.0.0.1:8080/v/0094aa1da8e1dd6ff0173f5bb879f8eb
```

## Redirect

```
http --pretty format get http://127.0.0.1:8080/v/0094aa1da8e1dd6ff0173f5bb879f8eb
```

```
HTTP/1.1 302 
Connection: keep-alive
Content-Language: pl-PL
Content-Length: 0
Date: Sun, 28 Feb 2021 11:48:00 GMT
Keep-Alive: timeout=60
Location: http://www.to.jest.dlugi.adres/ala-ma.kota/test.html

```

## Service status

```
http --pretty format get http://127.0.0.1:8080/
```

```
HTTP/1.1 200 
Connection: keep-alive
Content-Length: 2
Content-Type: text/plain;charset=UTF-8
Date: Sun, 28 Feb 2021 11:49:25 GMT
Keep-Alive: timeout=60

OK
```

