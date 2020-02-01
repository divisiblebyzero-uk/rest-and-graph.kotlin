[![Build Status](https://travis-ci.com/divisiblebyzero-uk/rest-and-graph.kotlin.svg?branch=master)](https://travis-ci.com/divisiblebyzero-uk/rest-and-graph.kotlin) ![CI](https://github.com/divisiblebyzero-uk/rest-and-graph.kotlin/workflows/CI/badge.svg)
# Rest and Graph Demonstration project - Kotlin implementation

This is a project to demo REST and GraphQL using Kotlin (and Spring boot). There are sister projects in Node.JS, C# and Java.

## Functional Description

The application has a simple entity model: Countries and Cities

### Country Example
```json
{
  "id": 1,
  "name": "UK",
  "language": "English"
}
```

### City Example
```json
{
  "id": 1,
  "name": "London",
  "country": {
    "id": 1,
    "name": "UK",
    "language": "English"
  },
  "size": "Huge"
}
```

These are modelled in the `entities` package.

## Implementation Description

By default, the application starts with a blank H2 database, and uses JPA to create the persistence structure (`repositories` package).

There are three implementations:

### Manual JSON API using JPA and RestController

In the `service.restcontroller` package is the web controller class.

The web controller has the following endpoints:
* http://localhost:8080/manual/insertData - Creates some data
* http://localhost:8080/manual/listAllCountries - Dumps out all countries
* http://localhost:8080/manual/listAllCities - Dumps out all cities

Note that the Cities are full-fat entities - ie the City record contains the entire Country record as well.

### RestRepository

In the `service.restrepositories` package are two RestRepository implementations:

* http://localhost:8080/countries
* http://localhost:8080/cities

These are fully Spring-managed REST repositories, and so you can GET the full list, GET by id, or POST a write.

Note that the Cities provide references (URIs) to the Country record. It's up to you to go get them.

### GraphQL

In the `service.graphql` are the Query and Mutation objects, and in `src/main/resources/graphql` is the graphqls files which define the contract.

The application includes an embedded graphiql interface, so fire it up and browse to http://localhost:8080/graphiql.

Don't forget to insert some test data (http://localhost:8080/manual/insertData) first otherwise you won't see anything.

You can browse the API using the docs link at the right hand side of graphiql, or alternatively try one of the following:

#### List all countries
```graphql
{
  countries {
    id
    name
    language
  }
}
```

#### Grab a particular country
```graphql
{
  country(id: 1) {
    id
    name
    language
  }
}
```

#### Grab a particular city
```graphql
{
  city(id: 1) {
    id
    name
    size
    country {
        name
    }       
  }
}
```


#### Insert a new country
```graphql
mutation {
  createCountry(name: "Bolivia", language: "Bolivian")
  {
    id
  }
}
```

Behind the scene, the queries and mutations are using the manual JPA repositories used in the first implementation.

## Running the application

Run via "gradlew bootRun".

As a convenience, http://localhost:8080/ will return a web page with links to the live URIs.

