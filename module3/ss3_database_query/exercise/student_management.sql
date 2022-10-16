use quan_li_sinh_vien;

select student_name from student
where student_name like 'H%';

select * from class
where month(start_date)=12;

select * from `subject`
where (credit between 3 and 5);

update student set class_id=2
where student_id=1;

select student.student_name,mark.mark,`subject`.sub_name from mark
inner join `subject` on mark.sub_id=`subject`.sub_id
inner join student on mark.student_id=student.student_id
order by mark desc,student_name asc;