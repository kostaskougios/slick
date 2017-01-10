-- drop tables
drop table product_attribute;
drop table attribute;
drop table product_category;
drop table category;
drop table product;


-- create schema
create table category (id int primary key, name text not null);

create table product(id int primary key, name text not null);

create table product_category(product_id int not null,category_id int not null, primary key (product_id,category_id));
alter table product_category add foreign key(product_id) references product(id);
alter table product_category add foreign key(category_id) references category(id);

create table attribute(id int primary key, name text not null, value text not null);

create table product_attribute(product_id int not null,attribute_id int not null, primary key (product_id,attribute_id));
alter table product_attribute add foreign key(product_id) references product(id);
alter table product_attribute add foreign key(attribute_id) references attribute(id);


-- sample data
insert into category(id,name) values(1,'cpus'),(2,'graphic cards');

insert into product(id,name) values(100,'i7'),(101,'i5');

insert into product_category(product_id,category_id) values(100,1),(101,1);

insert into attribute(id,name,value) values(200,'colour','red'),(201,'colour','blue');

insert into product_attribute(product_id,attribute_id) values(100,200),(101,201);