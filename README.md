# Code First API Example

This repository contains a Spring Boot Web application as an example, to generate OpenAPI 3 specification on `code-first` basis.
Generated open api spec is converted into a static html page to be served on [github pages](https://enisspahi.github.io/code-first-api-example/). 

## Starting the application

1. Start the application running:
`./gradlew :service:bootRun`
2. Observe open api specification:
* In [json format](http://localhost:8080/api-docs)
* In [yaml format](http://localhost:8080/api-docs.yaml)

## Generating API specification without running the application
`./gradlew generateOpenApiDocs`

## Below are some examples of generating single page API Docs with multiple tools: 


### Generating API Docs as a single page API Doc using [Redocly](https://redocly.com/)

1. Ensure `redocly` is installed. Instructions: https://redocly.com/docs/redoc/deployment/cli/
2. Run cli to generate single page API Doc
`redocly build-docs service/build/openapi.yaml -o docs/redoc/index.html`
3. Observe generated `docs/redoc/index.html` page

**[github-actions job](https://github.com/enisspahi/code-first-api-example/actions/workflows/api-docs-with-redoc.yml)** can trigger the API Docs generation and publishes the generated docs to github pages. 

### Generating API Docs as a single page API Doc using [Rapidoc](https://rapidocweb.com/)

1. Run the following command to copy the up-to-date Open API Spec under `docs/rapidoc/`
`cp service/build/openapi.yaml docs/rapidoc/`
2. Run and observe `docs/rapidoc/index.html` page

**[github-actions job](https://github.com/enisspahi/code-first-api-example/actions/workflows/api-docs-with-rapidoc.yml)** can trigger the API Docs generation and publishes the generated docs to github pages. 

### Generating API Docs as a single page API Doc using [Stoplight Elements](https://stoplight.io/open-source/elements)

1. Run the following command to copy the up-to-date Open API Spec under `docs/elements/`
   `cp service/build/openapi.yaml docs/elements/`
2. Run and observe `docs/elements/index.html` page

**[github-actions job](https://github.com/enisspahi/code-first-api-example/actions/workflows/api-docs-with-elements.yml)** can trigger the API Docs generation and publishes the generated docs to github pages. 

