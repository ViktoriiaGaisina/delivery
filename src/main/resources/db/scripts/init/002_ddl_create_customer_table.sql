create table if not exists delivery.customer(
     customer_id serial primary key,
     username varchar not null,
     password varchar not null,
     email varchar not null
);