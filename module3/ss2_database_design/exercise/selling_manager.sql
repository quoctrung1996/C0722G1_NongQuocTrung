create database quan_li_ban_hang;
use quan_li_ban_hang;

create table customer(
cID int not null primary key auto_increment,
`name` varchar(25) not null,
cAge tinyint
);

create table `order`(
oID int not null primary key auto_increment,
cID int,
oDate datetime not null,
oTotalPrice int,
foreign key(cID) references customer(cID)
);

create table product(
pID int not null primary key auto_increment,
pName varchar(25)not null,
pPrice int not null
);

create table order_detail(
oID int,
pID int,
odQTY int check(odQTY>=1),
foreign key(oID) references `order`(oID),
foreign key(pID) references product(pID)
);
