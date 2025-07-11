create table products (
     id bigint auto_increment primary key,
     name varchar(255),
     price int,
     imageUrl varchar(512)
);

create table users (
    id bigint auto_increment primary key,
    email varchar(255) not null unique,
    password varchar(255) not null
)

create table wish (
    userId bigint not null,
    productId bigint not null,
    number bigint check ( number > 0 )
)