# Getting started

> To install and manage the required runtime versions of the required tools, this project uses asdf: https://asdf-vm.com/. 

From within the project's root:
1. Run `adsf install` to install the required tools (mainly, the JDK).
2. Run `. ~/.asdf/plugins/java/set-java-home.zsh` to properly set `JAVA_HOME`.
3. Run `./mvnw clean package` to verify you can succesfully compile and build the project.

# Scaffolding

> Some information about how this project was scaffolded.

## Dependencies
A selection of the tools and dependencies include:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#data.sql.jooq)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web.reactive)

