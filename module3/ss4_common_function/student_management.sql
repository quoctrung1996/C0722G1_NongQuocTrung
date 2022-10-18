use quan_li_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from `subject`
where credit=(select max(credit)from `subject`);
 
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from mark
join `subject` on mark.sub_id=`subject`.sub_id
where mark=(select max(mark) from mark)
group by mark.sub_id;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student_name,address,phone,avg(mark)from student
join mark on student.student_id=mark.student_id
group by student.student_id
order by avg(mark) desc;