create table if not exists package(
    package_id text not null primary key,
    shipment_id integer not null,
    item_id integer not null,
    order_id text not null,
    courier_id integer,
    shipment_status text not null
)