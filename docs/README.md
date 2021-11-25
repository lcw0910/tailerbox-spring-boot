
## Create
```http request
# Request
POST http://{{localhost}}/api/users
Content-Type: application/json

{
  "userId": "cwlee",
  "userName": "Cheolwon Lee",
  "email": "chlwn.lee@gmail.com"
}

# Response
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/api/users/6
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 25 Nov 2021 08:07:21 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "userId": "cwlee",
  "userName": "Cheolwon Lee",
  "email": "chlwn.lee@gmail.com",
  "updatedAt": "2021-11-25 08:07:21",
  "deletedAt": null,
  "createdAt": "2021-11-25 08:07:21",
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/users/6"
    },
    "user": {
      "href": "http://localhost:8080/api/users/6"
    }
  }
}

Response code: 201; Time: 170ms; Content length: 370 bytes

```

## Read (List)
```http request
# Request
GET http://{{localhost}}/api/users

# Response
GET http://localhost:8080/api/users

HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 25 Nov 2021 08:10:38 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "_embedded": {
    "users": [
      {
        "userId": "cwlee",
        "userName": "Cheolwon Lee",
        "email": "chlwn.lee@gmail.com",
        "updatedAt": "2021-11-25 08:07:21",
        "deletedAt": null,
        "createdAt": "2021-11-25 08:07:21",
        "_links": {
          "self": {
            "href": "http://localhost:8080/api/users/6"
          },
          "user": {
            "href": "http://localhost:8080/api/users/6"
          }
        }
      },
      {
        "userId": "dennis02",
        "userName": "Dennis",
        "email": "dennis@gmail.com",
        "updatedAt": "2021-11-25 08:10:32",
        "deletedAt": null,
        "createdAt": "2021-11-25 08:10:32",
        "_links": {
          "self": {
            "href": "http://localhost:8080/api/users/7"
          },
          "user": {
            "href": "http://localhost:8080/api/users/7"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/users"
    },
    "profile": {
      "href": "http://localhost:8080/api/profile/users"
    }
  },
  "page": {
    "size": 10,
    "totalElements": 2,
    "totalPages": 1,
    "number": 0
  }
}

Response code: 200; Time: 220ms; Content length: 1189 bytes
```

## List (by Identifier)
```http request
GET http://localhost:8080/api/users/6

HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 25 Nov 2021 08:16:10 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "userId": "cwlee",
  "userName": "Cheolwon Lee",
  "email": "chlwn.lee@gmail.com",
  "updatedAt": "2021-11-25 08:07:21",
  "deletedAt": null,
  "createdAt": "2021-11-25 08:07:21",
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/users/6"
    },
    "user": {
      "href": "http://localhost:8080/api/users/6"
    }
  }
}

Response code: 200; Time: 172ms; Content length: 370 bytes
```

## Update
```http request
# Request
PUT http://localhost:8080/api/users/6
Content-Type: application/json

{
  "userId": "cwlee02",
  "userName": "Cheolwon",
  "email": "foo@bar.com"
}

# Response
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/api/users/6
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 25 Nov 2021 08:18:45 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "userId": "cwlee02",
  "userName": "Cheolwon",
  "email": "foo@bar.com",
  "updatedAt": "2021-11-25 08:18:45",
  "deletedAt": null,
  "createdAt": "2021-11-25 08:07:21",
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/users/6"
    },
    "user": {
      "href": "http://localhost:8080/api/users/6"
    }
  }
}

Response code: 200; Time: 83ms; Content length: 360 bytes

```
## Patch
```http request
# Request
PATCH http://localhost:8080/api/users/6
Content-Type: application/json

{
  "userName": "changeName"
}

# Response
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 25 Nov 2021 08:19:15 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "userId": "cwlee02",
  "userName": "changeName",
  "email": "foo@bar.com",
  "updatedAt": "2021-11-25 08:19:15",
  "deletedAt": null,
  "createdAt": "2021-11-25 08:07:21",
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/users/6"
    },
    "user": {
      "href": "http://localhost:8080/api/users/6"
    }
  }
}

Response code: 200; Time: 174ms; Content length: 362 bytes

```
## Delete
```http request
# Request
DELETE http://localhost:8080/api/users/6

# Response
HTTP/1.1 204 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Date: Thu, 25 Nov 2021 08:20:47 GMT
Keep-Alive: timeout=60
Connection: keep-alive

<Response body is empty>

Response code: 204; Time: 165ms; Content length: 0 bytes

```
