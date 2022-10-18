use quan_li_ban_hang;

insert into customer value
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into `order`(o_id,c_id,o_date) value
(1,1,'2006/3/21'),
(2,2,'2006/3/23'),
(3,1,'2006/3/16');

insert into product value
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail value
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

