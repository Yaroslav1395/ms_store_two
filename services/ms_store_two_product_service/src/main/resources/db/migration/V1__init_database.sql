create table if not exists categories
(
    id          integer not null                  primary key,
    description varchar(255),
    name        varchar(255)
    );

create table if not exists products
(
    id                 integer          not null  primary key,
    available_quantity double precision not null,
    description        varchar(255),
    name               varchar(255),
    price              numeric(38, 2),
    category_id        integer
    constraint fk1mtsbur82frn64de7balymq9s
    references categories
    );

create sequence if not exists categories_seq increment by 50;
create sequence if not exists products_seq increment by 50;