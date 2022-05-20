<h1 align="center">Microservice for Load CSV files</h1>

Content
=================
<!--ts-->
* [About](#About)
* [Config Gradle file](#Config-gradle-file)
* [Instalação](#instalacao)
* [Como usar](#como-usar)
    * [Pre Requisitos](#pre-requisitos)
    * [Local files](#local-files)
    * [Remote files](#remote-files)
    * [Multiple files](#multiple-files)
    * [Combo](#combo)
* [Tests](#testes)
* [Tecnologias](#tecnologias)
<!--te-->

## Config gradle file
```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'com.oracle.database.security:osdt_core'
	implementation 'com.oracle.database.security:oraclepki'
	implementation 'com.oracle.database.security:osdt_cert'
	implementation 'com.oracle.database.jdbc:ojdbc8:21.5.0.0'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	compileOnly 'org.projectlombok:lombok'
}
```
