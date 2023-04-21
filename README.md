# Code First API Example

This repository contains a Spring Boot Web application as en example, yo generate OpenAPI 3 specification on `code-first` basis.
Generated open api spec is converted into a static html page to be served on [github pages](https://enisspahi.github.io/code-first-api-example/). 

## Starting the application

1. Start the application running:
`./gradlew bootRun`
2. Observe open api specification:
* In [json format](http://localhost:8080/api-docs)
* In [yaml format](http://localhost:8080/api-docs.yaml)

## Generating API specification without running the application
`./gradlew generateOpenApiDocs`

## Generating API Docs as a single page API Doc using [Redocly](https://redocly.com/)

1. Ensure `redocly` is installed. Instructions: https://redocly.com/docs/redoc/deployment/cli/
2. Run cli to generate single page API Doc
`redocly build-docs build/openapi.yaml -o docs/index.html`
3. Observe generated `docs/index.html` page

A [github-actions](https://github.com/enisspahi/code-first-api-example/actions/workflows/api-docs-with-redoc.yml) job can trigger the API Docs generation and publishes the generated docs to github pages. 

