# Getting started

> To install and manage the required runtime versions of the required tools, this project uses asdf: https://asdf-vm.com/. 

From within the project's root:
1. Run `adsf install` to install the required tools (JDK, Node.js).
2. Run `. ~/.asdf/plugins/java/set-java-home.zsh` to properly set `JAVA_HOME`.
3. Run `./mvnw clean install` to verify you can successfully compile and build the project's backend.

Then:
1. From within `ulf-front`, run `npm i` to install the frontend dependencies.

# Scaffolding

> Some information about how this project was scaffolded.

## Dependencies
A selection of the tools and dependencies include:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#data.sql.jooq)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web.reactive)

