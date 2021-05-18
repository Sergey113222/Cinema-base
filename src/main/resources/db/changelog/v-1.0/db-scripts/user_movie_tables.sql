create table user_movie
(
    id         bigint auto_increment primary key,
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