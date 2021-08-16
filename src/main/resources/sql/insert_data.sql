INSERT INTO `genre`
VALUES (1, 'Comedy', '2021-05-02 12:00:23', NULL),
       (2, 'Horror', '2021-05-02 12:00:45', NULL),
       (3, 'Drama', '2021-05-02 12:00:46', NULL),
       (4, 'Fantasy', '2021-05-02 12:00:55', NULL);

INSERT INTO `movie`
VALUES (1, 'Matrix', NULL, NULL, 8.5,
        'Matrix movie description example description example description example description example description example description example description example description example description example description example description example description example description example description example description example description example description example ',
        0, '2021-05-02 12:02:02', NULL),
       (2, 'Always say \'YES\'', NULL, NULL, 9.2,
        'Movie with Jim Carry description example description example description example description example description example description example description example description example description example ',
        0, '2021-05-02 12:03:11', NULL);

INSERT INTO `movie_genre`
VALUES (2, 1),
       (1, 4),
       (1, 2);

INSERT INTO `profile`
VALUES (1, NULL, 'java developer, volunteer, nice guy','test1@gmail.com', 'Raman', 'Kashanok', 36, 'male', 'BY', 'ru',
        '2021-05-02 12:05:06', NULL),
       (2, NULL, 'java trainee', 'test2@gmai.com', 'Sergey', 'Gritsuk', 35, 'male', 'BY', 'ru', '2021-05-02 12:05:41', NULL),
       (3, NULL, 'java trainee', 'yasyuchenya1@gmail.com', 'Denis', 'Yasiuchenia', 25, 'male', 'BY', 'ru', '2021-05-02 12:06:13', NULL);

INSERT INTO `user`
VALUES (1, 'kashenok.r', 'password1', 'USER', 1, 1, NULL, '2021-05-02 12:06:49'),
       (2, 'gritsuk.s', 'password2', 'USER', 1, 2, NULL, '2021-05-02 12:07:08'),
       (3, 'yasiuchenia.d', 'password3', 'USER', 1, 3, NULL, '2021-05-02 12:07:34');

INSERT INTO `user_movie`
VALUES (1, 1, 1, 8, 'Надо посмотреть на ближайших выходных', 0, '2021-05-02 12:08:34', NULL),
       (2, 1, 2, 9, 'Надо посмотреть вечером', 0, '2021-05-02 12:08:53', NULL),
       (3, 2, 2, 8, 'Гляну при возможности', 0, '2021-05-02 12:09:18', NULL),
       (4, 2, 1, 9, 'Посмотрел, все же на 8ку...', 1, '2021-05-02 12:09:35', NULL),
       (5, 3, 1, 7, 'Не люблю фантастику, но Киану молодец!', 0, '2021-05-02 12:10:25', NULL),
       (6, 3, 2, 9, 'Нравится Джим Керри. Обязательно посмотрю', 1, '2021-05-02 12:11:01', NULL);
