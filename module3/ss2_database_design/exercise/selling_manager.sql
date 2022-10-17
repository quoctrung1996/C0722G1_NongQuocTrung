drop database if exists quan_li_ban_hang;

create database quan_li_ban_hang;
use quan_li_ban_hang;

create table customer(
c_id int not null primary key auto_increment,
`name` varchar(25) not null,
c_age tinyint
);

create table `order`(
o_id int not null primary key auto_increment,
c_id int,
o_date datetime not null,
o_total_price int,
foreign key(c_id) references customer(c_id)
);

create table product(
p_id int not null primary key auto_increment,
p_name varchar(25)not null,
p_price int not null
);

create table order_detail(
o_id int,
p_id int,
od_qty int check(od_qty>=1),
primary key(o_id,p_id),
foreign key(o_id) references `order`(o_id),
foreign key(p_id) references product(p_id)
);

