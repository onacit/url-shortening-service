# URL Shortening Application

A simple URL-shortening application.

## APIs

### `GET /`
Initializes and returns initial page name.

### `POST /shorten`
Shortens given form data.
```
POST /shorten HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded

originalUrl=http%3A%2F%2Fwww.daum.net
```
```
HTTP/1.1 200 OK
Content-Type: text/html

<html>
...
</html>
```

### `GET /widen/{shortenedId}`
(Re)Widen specified `shortenedId` and redirects the original URL.
(A new tab/window may pop.)
```
GET /widen/{shortenedId} HTTP/1.1
Host: localhost:8080

```
```
HTTP/1.1 302 Found
Location: <original-url>

```


## Build, run, and see

Build the application and run.

```shell
$ gradlew clean bootRun
...
$
```

Open [http://localhost:8080](http://localhost:8080) with your browser.