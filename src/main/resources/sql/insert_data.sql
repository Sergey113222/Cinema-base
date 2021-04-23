INSERT INTO movie_trash.users (username, password, role, status, created_at, updated_at)
VALUES ('Sergey', 'G113222', 'GUEST', 'ONLINE', now(), now()),
       ('Roman', 'G113221', 'ADMIN', 'OFFLINE', now(), now()),
       ('Denis', 'G113223', 'GUEST', 'ONLINE', now(), now());
INSERT INTO movie_trash.profile (avatar, userbio, first_name, last_name, age, gender, region, language, usercreated_at, userupdated_at)
VALUES  ('url','Junior Java Developer','Sergey','Gritsuk','25','MALE','Belarus','Russian',now(),now()),
        ('url','Java Team Lead','Roman','Kashenok','25','MALE','Belarus','Russian',now(),now()),
        ('url','Java addicted lazy ass','Denis','Yasyucnenya','25','MALE','Belarus','Russian',now(),now());
INSERT INTO movie_trash.movie (name, genre, poster, year, rating, favorite, description, agerestrictions, review)
VALUES  ('Titanic','Drama','null','1997','5.0','null','Titanic is a 1997 American epic romance and disaster film.',16,'null'),
        ('The Terminator','Sci-fi','null','1984','4.5','null','The Terminator is a 1984 science fiction film.',18,'null');
INSERT INTO movie_trash.user_role (userrole)
VALUES (null);
INSERT INTO movie_trash.user_movie (userrating, userfavs, userreview)
VALUES (null);