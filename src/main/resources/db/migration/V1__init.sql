create table users (
    id bigserial primary key,
    nickname varchar(128) unique not null,
    email varchar(128) unique not null,
    password varchar(80) not null
);

create table roles (
    id bigserial primary key,
    role varchar(16) not null unique
);

insert into roles values
                      (1, 'USER'),
                      (2, 'ADMIN');

create table user_roles (
    user_id bigint references users,
    role_id bigint references roles,
    primary key (user_id, role_id)
);