CREATE DATABASE movie_trash;

create table genre
(
    id      bigint auto_increment               primary key,
    name    varchar(100)                        null,
    created timestamp default CURRENT_TIMESTAMP not null,
    updated timestamp                           null
);

create table movie
(
    id           bigint auto_increment                primary key,
    title        varchar(255)                         not null,
    poster       varchar(1000)                        null,
    premier_date timestamp                            null,
    imdb         double                               null,
    description  varchar(1000)                        null,
    is_adult     tinyint(1) default 0                 not null,
    created      timestamp  default CURRENT_TIMESTAMP not null,
    updated      timestamp                            null
);

create index moviee_id_index
    on movie (id);

create table movie_genre
(
    movie_id bigint not null,
    genre_id bigint not null,
    primary key (genre_id, movie_id)
);

create index movie_genre_id_index
    on movie_genre (genre_id);

create table profile
(
    id         bigint auto_increment               primary key,
    avatar     varchar(1000)                       null,
    about      varchar(500)                        null,
    first_name varchar(50)                         null,
    last_name  varchar(50)                         null,
    age        int                                 not null,
    gender     varchar(10)                         not null,
    region     varchar(2)                          null,
    language   varchar(2)                          null,
    created    timestamp default CURRENT_TIMESTAMP not null,
    updated    timestamp                           null
);

create index profile_id_index
    on profile (id);

create table user
(
    id         bigint auto_increment                primary key,
    username   varchar(255)                         not null,
    password   varchar(255)                         not null,
    role       varchar(10)                          not null,
    active     tinyint(1) default 1                 not null,
    profile_id bigint                               not null,
    updated    timestamp                            null,
    created    timestamp  default CURRENT_TIMESTAMP not null,
    constraint user_profile_fk
        foreign key (profile_id) references profile (id)
            on update cascade on delete cascade
);

create table user_movie
(
    id         bigint auto_increment                primary key,
    profile_id bigint                               not null,
    movie_id   bigint                               not null,
    rating     int                                  null,
    notes      varchar(128)                         null,
    viewed     tinyint(1) default 0                 not null,
    created    timestamp  default CURRENT_TIMESTAMP not null,
    updated    timestamp                            null,
    constraint user_movie_movie_id_fk
        foreign key (movie_id) references movie (id),
    constraint user_movie_profile_id_fk
        foreign key (profile_id) references profile (id)
);

