insert into profile (id, email,  created)
values (8, 'k-grine@mail.ru', now());

insert into user (id, username, password, role, active, profile_id, created)
values (8,
        'TestUsername',
        'TestPassword',
        'ROLE_USER',
        1,
        8,
        now());