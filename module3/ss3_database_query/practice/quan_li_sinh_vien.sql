use quan_li_sinh_vien;

insert into class value
(1,'A1','2008-12-20',1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);

insert into student value
(1,'Hung', 'Ha Noi', '0912113113', 1, 1),
(2,'Hoa', 'Hai phong','0123456778',1, 1),
(3,'Manh', 'HCM', '0123123123', 0, 2);

insert into `subject` value
(1, 'CF', 5, 1),
(2, 'C', 6, 1),
(3, 'HDJ', 5, 1),
(4, 'RDBMS', 10, 1);

insert into mark(sub_id, student_id, mark, exam_times) value
(1, 1, 8, 1),
(2, 2, 10, 2),
(3, 3, 12, 1);
