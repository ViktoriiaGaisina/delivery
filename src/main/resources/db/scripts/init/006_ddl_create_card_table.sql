create table if not exists delivery.card(
  card_id serial primary key,
  name_owner varchar not null,
  card_number varchar not null unique,
  expiry_date timestamp not null,
  cvv varchar not null unique,
  balance numeric(10,2),
  fk_customer_id int references delivery.customer(customer_id)
);