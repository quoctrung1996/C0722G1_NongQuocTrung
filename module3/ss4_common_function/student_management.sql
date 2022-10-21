use quan_li_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT 
    *
FROM
    `subject`
WHERE
    credit = (SELECT 
            MAX(credit)
        FROM
            `subject`);
 
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT 
    *
FROM
    mark
        JOIN
    `subject` ON mark.sub_id = `subject`.sub_id
WHERE
    mark = (SELECT 
            MAX(mark)
        FROM
            mark)
GROUP BY mark.sub_id;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT 
    student_name, address, phone, AVG(mark)
FROM
    student
        JOIN
    mark ON student.student_id = mark.student_id
GROUP BY student.student_id
ORDER BY AVG(mark) DESC;