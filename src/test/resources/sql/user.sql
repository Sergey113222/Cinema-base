insert into profile (id, age, gender, created)
values (1L, 20, 'M', now());

insert into user (id, username, password, role, active, profile_id, created)
values (1,
        'TestUsername',
        'TestPassword',
        'USER',
        1,
        1,
        now());