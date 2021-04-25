CREATE
DATABASE movie_trash;

CREATE TABLE user
(
    id       BIGINT    NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    role     VARCHAR(10),
    active   TINYINT(1),
    created  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated  TIMESTAMP NULL     DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE profile
(
    id         BIGINT    NOT NULL AUTO_INCREMENT,
    user_id    BIGINT    NOT NULL,
    avatar     VARCHAR(100),
    about      VARCHAR(500),
    first_name VARCHAR(20),
    last_name  VARCHAR(20),
    age        INT       NOT NULL DEFAULT 0,
    gender     VARCHAR(10),
    region     VARCHAR(2),
    language   VARCHAR(2),
    created    TIMESTAMP NOT NULL DEFAULT NOW(),
    updated    TIMESTAMP NULL     DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movie
(
    id               BIGINT    NOT NULL AUTO_INCREMENT,
    name             VARCHAR(50),
    poster           VARCHAR(50),
    year             VARCHAR(10),
    rating_imdb      DOUBLE    not null,
    description      MEDIUMTEXT,
    agere_strictions INT,
    created          TIMESTAMP NOT NULL DEFAULT NOW(),
    updated          TIMESTAMP NULL     DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE genre
(
    id      INT(3)    NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50),
    created TIMESTAMP NOT NULL DEFAULT NOW(),
    updated TIMESTAMP NULL     DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movie_genre
(
    movie_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL
);
ALTER TABLE movie_genre ADD FOREIGN KEY (movie_id) REFERENCES movie(id);
ALTER TABLE movie_genre ADD FOREIGN KEY (genre_id) REFERENCES genre(id);

CREATE TABLE user_movie
(
    user_id   BIGINT NOT NULL,
    movie_id  BIGINT NOT NULL,
    rating    DOUBLE,
    favourite TINYINT(1),
    review    VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (movie_id) REFERENCES movie (id)
);
