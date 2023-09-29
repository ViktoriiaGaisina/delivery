create table if not exists delivery.order_dish(
order_dish_id serial primary key,
fk_order_id int references delivery.orders(order_id),
fk_dish_id int references delivery.dish(dish_id)
);