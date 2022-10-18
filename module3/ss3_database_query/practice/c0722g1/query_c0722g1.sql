use c0722g1;
-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
select * from student
inner join class on student.class_id=class.id;
-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào và cả các bạn đã đăng ký nhưng chưa có lớp học.
select * from student
left join class on student.class_id=class.id;
-- 4. Lấy thông tin của các học viên tên “Hai” và 'Huynh’.
select * from student
where `name`like '%Hai' or `name` like '%Huynh';
-- 5. Lấy ra học viên có điểm lớn hơn 5 .
select student.name from student
where point>5;
-- 6. Lấy ra học viên có họ là “nguyen”
select student.name from student
where name like 'nguyen%';
-- 7. Thông kế số lượng học sinh theo từng loại điểm.
select sum(student.id) from student
group by point;
-- 8 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
select sum(student.id) from student
where point >5
group by point;
-- 9. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
select sum(student.id) from student
where point >5
group by point
having sum(student.id)>=2;
-- 10. Lấy ra danh sách học viên của lớp "c1121g1" và sắp xếp tên học viên theo alphabet.
select * from student
inner join class on student.class_id=class.id
where student.name='c1121g1'
order by student.name;