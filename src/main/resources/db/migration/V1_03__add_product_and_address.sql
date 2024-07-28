create table if not exists address
(
    id            integer not null primary key,
    type          text    not null,
    city          text    not null,
    zip           text    not null,
    street_name   text    not null,
    street_number text    not null
);

create table if not exists merchant_product
(
    merchant_inventory_id integer                         not null primary key,
    name                  text                            not null,
    description           text,
    serviceable           boolean                         not null default false,
    bulky                 boolean                         not null default false,
    pickup_address        integer
        constraint fk_pickup_addr references address (id) not null,
    return_address        integer
        constraint fk_return_addr references address (id) not null,
    stock_level           integer                         not null,
    reserved_level        integer                         not null
);