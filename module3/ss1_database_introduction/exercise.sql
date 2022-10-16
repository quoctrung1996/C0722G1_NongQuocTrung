create database if not exists `student-management`;
use `student-management`;

create table student(
id int primary key,
`name` varchar(45),
age int,
country varchar(45));

create table class(
id int primary key,
`name` varchar(45));

create table teacher(
id int,
`name` varchar(50),
age int,
`country` varchar(50));


insert into student(id,`name`,age,country)value(1,'trung',26,'VietNam'),
(2,'trung2',26,'VietNam'),
(3,'trung3',26,'VietNam'); 
insert into student value(4,'trung4',26,'VietNam');
select id,`name`from student;
set SQL_SAFE_UPDATES=0;
delete from student where id=1;
update student set age=20;
set SQL_SAFE_UPDATES=1;
delete from student where id=2;
select *from student;


insert into Class(id,`name`)value(1,'trung'),(2,'nam'),(3,'long');
insert into Class value(4,'trung');
select id,`name`from Class;
update Class set `name`='bro' where id=4;
set SQL_SAFE_UPDATES=0;
update Class set `name`='anh';
delete from Class where id=4;
set SQL_SAFE_UPDATES=1;
select *from Class;

insert into Teacher(id,`name`,age,`country`)value
(1,'trung',20,'Viet Nam'),
(2,'trung',20,'Viet Nam'),
(3,'trung',20,'Viet Nam');
select *from Teacher;
update Teacher set `name`='Kha'where id=3;
insert into Teacher value(4,'Kha',20,'Viet Nam');





