create table categories
(
    id   varchar(255) not null
        primary key,
    name varchar(255)
);

alter table categories
    owner to hits;

create table users
(
    id       varchar(255) not null
        primary key,
    password varchar(255),
    role     varchar(255),
    username varchar(255)
);

alter table users
    owner to hits;

create table quizzes
(
    id          varchar(255) not null
        primary key,
    description varchar(255),
    difficult   varchar(255),
    name        varchar(255),
    author_id   varchar(255)
        constraint fk7ifwq8adfbjh1v79urcbqxu84
            references users,
    category_id varchar(255)
        constraint fkpo9fnqd9hnnmg8qxiyue40cot
            references categories
);

alter table quizzes
    owner to hits;

create table questions
(
    id      varchar(255) not null
        primary key,
    text    varchar(255),
    quiz_id varchar(255)
        constraint fkn3gvco4b0kewxc0bywf1igfms
            references quizzes
);

alter table questions
    owner to hits;

create table answer_options
(
    id          varchar(255) not null
        primary key,
    is_right    boolean,
    text        varchar(255),
    question_id varchar(255)
        constraint fkfapodm8kfiu9a9a4o2r43rcgp
            references questions
);

alter table answer_options
    owner to hits;

create table results
(
    id        varchar(255) not null
        primary key,
    quantity  integer,
    author_id varchar(255)
        constraint fkdq393k12aw7tjh7vm892ye4rk
            references users,
    quiz_id   varchar(255)
        constraint fkt6q4hhocvhex1y4e6xpcb4b9y
            references quizzes
);

alter table results
    owner to hits;

