alter table package
    add column if not exists merchant_inventory_id integer;
alter table package
    alter column merchant_inventory_id set not null;