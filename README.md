# City Suggestions Program

**Examples**

Using curl to testing the REST Endpoint

Get suggestions only with the name of the city

```
curl --location --request GET 'https://our-tracker-351620.uw.r.appspot.com/suggestions?q=l0nd1n'
```

Get suggestions with the name and latitude/longitude based

```
curl --location --request GET 'http://localhost:8080/suggestions?q=L0ndon&latitude=43.700&longitude=-81'
```

