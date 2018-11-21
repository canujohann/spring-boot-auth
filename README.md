## Basic use


### Issues a GET request to retrieve tasks with no JWT

```shell
# HTTP 403 Forbidden status is expected
curl http://localhost:8080/tasks
```

Response as expected:

```shell
{"timestamp":1542758386388,"status":403,"error":"Forbidden","message":"Access Denied","path":"/tasks"}
```


### Register a new user

```shell
curl -H "Content-Type: application/json" -X POST -d '{ "username": "admin", "password": "password" }' http://localhost:8080/users/sign-up
```

### logs into the application (JWT is generated)

```shell
curl -i -H "Content-Type: application/json" -X POST -d '{"username": "admin", "password": "password"}' http://localhost:8080/login
```

Response should be something like:

```shell
HTTP/1.1 200
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU0MzYyMjgxM30.ExB8ThWesPF0VHCt0IbD_kOxp_gdnHGTd8Cl7DsnNYor0CajvzbWjxN4PmaadESGH28YvWIwxwsK1g53m-MxHg
Content-Length: 0
Date: Wed, 21 Nov 2018 00:06:53 GMT
```


### issue a POST request, passing the JWT, to create a task

```shell
# Replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Content-Type: application/json" \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X POST -d '{"description": "Buy watermelon"}'  http://localhost:8080/tasks
```

### issue a new GET request, passing the JWT

```shell
# remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/tasks
```

Response should be :

```shelll
[{"id":1,"description":"Buy watermelon"}]
```

