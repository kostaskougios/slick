drop table product_category;
drop table category;
drop table product;


create table category (id int primary key, name text not null);


create table product(id int primary key, name text not null);

create table product_category(product_id int not null,category_id int not null, primary key (product_id,category_id));
alter table product_category add foreign key(product_id) references product(id);
alter table product_category add foreign key(category_id) references category(id);

