create table pizzeria
(
  id identity not null,
  pizzaname varchar(255) not null,
  ticket varchar(7) not null,
  status varchar(255) not null,
  primary key(id)
);