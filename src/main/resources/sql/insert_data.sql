INSERT INTO movie_trash.user (username, password, role, active, created, updated)
VALUES ('Sergey', 'G113222', 'GUEST', true, now(), now()),
       ('Roman', 'G113221', 'ADMIN', true, now(), now()),
       ('Denis', 'G113223', 'GUEST', false, now(), now());
INSERT INTO movie_trash.user (username, password, role, active, created, updated)
VALUES ('Sergey', 'G113222', 'GUEST', true, now(), now()),
       ('Roman', 'G113221', 'ADMIN', true, now(), now()),
       ('Denis', 'G113223', 'GUEST', false, now(), now());
INSERT INTO profile (user_id, avatar, about, first_name, last_name, age, gender, region, language, created, updated)
VALUES ('1','URL','Junior java developer.','Sergey','Gritsuk','25','Male','Be','Ru',NOW(),NOW()),
       ('2','URL','Java team lead.','Roman','Kashenok','25','Male','Be','Ru',NOW(),NOW()),
       ('3','URL','Just a nice guy.','Denis','Yasyuchenya','25','Male','Be','Ru',NOW(),NOW());
INSERT INTO movie (name, poster, year, rating_imdb, description, agere_strictions, created, updated)
VALUES ('Titanic','URL','1997','9','The human story involves an 17-year-old woman named Rose DeWitt Bukater (Kate Winslet) who is...','16', NOW(),NOW()),
       ('Terminator','URL','1984','8.7','In 1984 Los Angeles, a cyborg assassin known as a Terminator arrives from 2029, where mankind...','18',NOW(),NOW());
INSERT INTO genre (name, created, updated)
VALUES ('Titanic',NOW(),NOW()),
       ('Terminator',NOW(),NOW());
INSERT INTO movie_genre (movie_id, genre_id)
VALUES ('1','1'),
        ('2','2');
INSERT INTO user_movie (user_id, movie_id, rating, favourite, review)
VALUES  ('1','1','7.0',false,'Great movie about love.'),
        ('2','2','10.0',true,'One of my favorite movies');