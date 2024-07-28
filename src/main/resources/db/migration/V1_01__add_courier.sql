create table courier
(
    id   serial not null primary key,
    name text   not null
);

insert into courier
values (1, 'One man delivery'),
       (2, 'Two men delivery');