## Cinema-base Rest Application

 - Java Backend application that connects to the API of https://www.themoviedb.org 
 and search, view movie descriptions, add reviews and save your favorite movies to the database. 
 
 - Technological stack: REST API, SpringBoot, Spring Data JPA, Spring Security + JWT, Hibernate, Database - MySQL, with migration Liquibase,
  Git, Maven, Intellij idea, OOP, Tests - JUnit, Mockito. 
  
 - TheMovieDB API documentations: https://developers.themoviedb.org/3/getting-started/introduction
 
 - Goodle Drive Link video https://drive.google.com/drive/folders/1S1FcpHI2M25dDK9B6OJkFyMACGgI57yk?usp=sharing
 
 - Access address to UI Swagger http://localhost:8080/swagger-ui/
  
 - DB:
   - for connection with database engine with existing database: run default profile. 
     Requirements: 1) create database ‘movie_trash’ 2) fill username and password fields in application.properties
   - for connection with embedded database: run application with profile ‘local’ (-Dspring.profiles.active=local)        