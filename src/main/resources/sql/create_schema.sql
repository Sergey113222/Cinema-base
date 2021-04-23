CREATE DATABASE movie_trash;

CREATE TABLE users
(
    id       BIGINT    NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id),
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    role VARCHAR(10),
    status   VARCHAR(50),
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW()
);
CREATE TABLE profile (
    userId BIGINT NOT NULL,
    usercreated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    userupdated_at TIMESTAMP DEFAULT NOW(),
    avatar VARCHAR(100),
    userbio TEXT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    age INT DEFAULT 16 CHECK(Age >0 AND Age < 100),
    gender VARCHAR(10),
    region VARCHAR(20),
    language VARCHAR(20)
);
CREATE TABLE user_role (
    userrole TINYINT (1)
);
CREATE TABLE movie (
    name VARCHAR(50),
    genre VARCHAR(50),
    poster VARCHAR(50),
    year INT,
    rating DOUBLE not null,
    favorite TINYINT(1),
    description MEDIUMTEXT,
    agerestrictions INT,
    review VARCHAR (100)
);
CREATE TABLE user_movie (
    userrating DOUBLE(5,0),
    userfavs TINYINT(1),
    FOREIGN KEY (userreview) REFERENCES movie (review),
    userreview VARCHAR(100)
);
