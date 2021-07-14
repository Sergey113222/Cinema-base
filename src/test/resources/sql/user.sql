insert into profile (id, email,  created)
values (6, 'k-grine@mail.ru', now());

insert into user (id, username, password, role, active, profile_id, created)
values (3,
        'TestUsername',
        'TestPassword',
        'USER',
        1,
        6,
        now());