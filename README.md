# City Suggestions Program

**Examples**

Using curl to testing the REST Endpoint

Get suggestions only with the name of the city

```
curl --location --request GET 'https://cities-351822.wn.r.appspot.com/suggestions?q=l0nd1n'
```

Get suggestions with the name and latitude/longitude based

```
curl --location --request GET 'https://cities-351822.wn.r.appspot.com/suggestions?q=L0ndon&latitude=43.700&longitude=-81'
```

This is a Postman Collection I was working on, if you want to take a look: [Collection](https://www.postman.com/efraimla/workspace/public-workspace/collection/20357074-f5e80867-23a6-438e-a1a7-fee43b6e1b07?action=share&creator=20357074)