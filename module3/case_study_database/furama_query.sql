use furama_resort;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT 
    *
FROM
    nhan_vien
WHERE
    (ho_ten LIKE 'H%' OR ho_ten LIKE 'T%'
        OR ho_ten LIKE 'K%')
        AND CHAR_LENGTH(ho_ten) <= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    *
FROM
    khach_hang
WHERE
    ((YEAR(CURDATE()) - YEAR(ngay_sinh)) BETWEEN 18 AND 50)
        AND (dia_chi LIKE '%Đà Nẵng'
        OR dia_chi LIKE '%Quảng Trị');

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT 
    k.ma_khach_hang,
    k.ho_ten,
    COUNT(ma_hop_dong) AS so_lan_dat_phong
FROM
    khach_hang k
        INNER JOIN
    hop_dong h ON k.ma_khach_hang = h.ma_khach_hang
WHERE
    k.ma_loai_khach = 1
GROUP BY ma_khach_hang
ORDER BY COUNT(ma_hop_dong);

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
--  tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là 
-- từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng.
--  (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT 
    k.ma_khach_hang,
    k.ho_ten,
    l.ten_loai_khach,
    h.ma_hop_dong,
    d.ten_dich_vu,
    h.ngay_lam_hop_dong,
    h.ngay_ket_thuc,
    SUM(d.chi_phi_thue + hd.so_luong * dv.gia) AS tong_tien
FROM
    loai_khach l
        JOIN
    khach_hang k ON k.ma_loai_khach = l.ma_loai_khach
        LEFT JOIN
    hop_dong h ON k.ma_khach_hang = h.ma_khach_hang
        LEFT JOIN
    dich_vu d ON h.ma_dich_vu = d.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hd ON h.ma_hop_dong = hd.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dv ON hd.ma_dich_vu_di_kem = dv.ma_dich_vu_di_kem
GROUP BY k.ma_khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT 
    d.ma_dich_vu,
    d.ten_dich_vu,
    d.dien_tich,
    d.chi_phi_thue,
    l.ten_loai_dich_vu,
    h.ngay_lam_hop_dong
FROM
    dich_vu d
        LEFT JOIN
    loai_dich_vu l ON d.ma_loai_dich_vu = l.ma_loai_dich_vu
        JOIN
    hop_dong h ON d.ma_dich_vu = h.ma_dich_vu
WHERE
    d.ma_dich_vu NOT IN (SELECT 
            d.ma_dich_vu
        FROM
            hop_dong
        WHERE
            MONTH(h.ngay_lam_hop_dong) IN (1 , 2, 3)
                AND YEAR(h.ngay_lam_hop_dong) = '2021')
GROUP BY d.ma_dich_vu;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue,
--  ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT 
    d.ma_dich_vu,
    d.ten_dich_vu,
    d.dien_tich,
    d.so_nguoi_toi_da,
    d.chi_phi_thue,
    l.ten_loai_dich_vu
FROM
    dich_vu d
        JOIN
    loai_dich_vu l ON d.ma_loai_dich_vu = l.ma_loai_dich_vu
        JOIN
    hop_dong h ON d.ma_dich_vu = h.ma_dich_vu
WHERE
    h.ma_dich_vu NOT IN (SELECT 
            h.ma_dich_vu
        FROM
            hop_dong h
        WHERE
            YEAR(ngay_lam_hop_dong) = 2021)
        AND YEAR(h.ngay_lam_hop_dong) = 2020
GROUP BY d.ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
--  Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- cach1:
select distinct ho_ten from khach_hang;
-- cach2:
select ho_ten from khach_hang
group by ho_ten;
-- cach3:
SELECT 
    ho_ten
FROM
    khach_hang 
UNION SELECT 
    ho_ten
FROM
    khach_hang;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT 
    MONTH(ngay_lam_hop_dong) AS thang,
    COUNT(ngay_lam_hop_dong) AS so_luong_khach_hang
FROM
    hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2021
GROUP BY MONTH(ngay_lam_hop_dong)
ORDER BY thang;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem
--  (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT 
    h.ma_hop_dong,
    h.ngay_lam_hop_dong,
    h.ngay_ket_thuc,
    h.tien_dat_coc,
    COUNT(hd.ma_dich_vu_di_kem) AS so_luong_dich_vu_di_kem
FROM
    hop_dong_chi_tiet hd
        RIGHT JOIN
    hop_dong h ON hd.ma_hop_dong = h.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dv ON hd.ma_dich_vu_di_kem = dv.ma_dich_vu_di_kem
GROUP BY h.ma_hop_dong;

-- 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng
--  có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT 
    dv.ma_dich_vu_di_kem, dv.ten_dich_vu_di_kem
FROM
    dich_vu_di_kem dv
        JOIN
    hop_dong_chi_tiet hd ON dv.ma_dich_vu_di_kem = hd.ma_dich_vu_di_kem
        JOIN
    hop_dong h ON hd.ma_hop_dong = h.ma_hop_dong
        JOIN
    khach_hang k ON h.ma_khach_hang = k.ma_khach_hang
        JOIN
    loai_khach l ON k.ma_loai_khach = l.ma_loai_khach
WHERE
    l.ten_loai_khach = 'Diamond'
        AND (k.dia_chi LIKE '% Vinh'
        OR k.dia_chi LIKE '% Quảng Ngãi');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng),
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng 
-- được khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT 
    h.ma_hop_dong,
    n.ho_ten AS ho_ten_nhan_vien,
    k.ho_ten AS ho_ten_khach_hang,
    k.so_dien_thoai AS sdt_khach_hang,
    d.ma_dich_vu,
    d.ten_dich_vu,
    IFNULL(SUM(hd.so_luong), 0) AS so_luong_dich_vu_di_kem,
    h.tien_dat_coc
FROM
    hop_dong h
        JOIN
    nhan_vien n ON h.ma_nhan_vien = n.ma_nhan_vien
        RIGHT JOIN
    khach_hang k ON h.ma_khach_hang = k.ma_khach_hang
        JOIN
    dich_vu d ON h.ma_dich_vu = d.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hd ON h.ma_hop_dong = hd.ma_hop_dong
WHERE
    h.ma_dich_vu NOT IN (SELECT 
            h.ma_dich_vu
        FROM
            hop_dong h
        WHERE
            QUARTER(h.ngay_lam_hop_dong) IN (1 , 2)
                AND YEAR(h.ngay_lam_hop_dong) = 2021)
        AND QUARTER(h.ngay_lam_hop_dong) = 4
        AND YEAR(h.ngay_lam_hop_dong) = 2020
GROUP BY h.ma_hop_dong;

-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT 
    dv.ma_dich_vu_di_kem,
    dv.ten_dich_vu_di_kem,
    SUM(hd.so_luong) AS so_luong_dich_vu_di_kem
FROM
    dich_vu_di_kem dv
        JOIN
    hop_dong_chi_tiet hd ON dv.ma_dich_vu_di_kem = hd.ma_dich_vu_di_kem
GROUP BY hd.ma_dich_vu_di_kem
HAVING (so_luong_dich_vu_di_kem) >= ALL (SELECT 
        SUM(hd.so_luong)
    FROM
        hop_dong_chi_tiet hd
    GROUP BY hd.ma_dich_vu_di_kem);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, 
-- so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT 
    hd.ma_hop_dong,
    l.ten_loai_dich_vu,
    dv.ten_dich_vu_di_kem,
    COUNT(dv.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM
    hop_dong_chi_tiet hd
        JOIN
    hop_dong h ON hd.ma_hop_dong = h.ma_hop_dong
        JOIN
    dich_vu_di_kem dv ON hd.ma_dich_vu_di_kem = dv.ma_dich_vu_di_kem
        JOIN
    dich_vu d ON h.ma_dich_vu = d.ma_dich_vu
        JOIN
    loai_dich_vu l ON d.ma_loai_dich_vu = l.ma_loai_dich_vu
GROUP BY dv.ma_dich_vu_di_kem
HAVING COUNT(dv.ma_dich_vu_di_kem) = 1
ORDER BY hd.ma_hop_dong;

-- 15.Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, 
-- ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT 
    n.ma_nhan_vien,
    n.ho_ten,
    t.ten_trinh_do,
    b.ten_bo_phan,
    n.so_dien_thoai,
    n.dia_chi
FROM
    nhan_vien n
        JOIN
    trinh_do t ON n.ma_trinh_do = t.ma_trinh_do
        JOIN
    bo_phan b ON n.ma_bo_phan = b.ma_bo_phan
        JOIN
    hop_dong h ON n.ma_nhan_vien = h.ma_nhan_vien
WHERE
    YEAR(h.ngay_lam_hop_dong) IN (2020 , 2021)
GROUP BY n.ma_nhan_vien
HAVING COUNT(n.ma_nhan_vien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SELECT 
    n.ma_nhan_vien, n.ho_ten
FROM
    nhan_vien n
        LEFT JOIN
    hop_dong h ON n.ma_nhan_vien = h.ma_nhan_vien
WHERE
    n.ma_nhan_vien NOT IN (SELECT 
            n.ma_nhan_vien
        FROM
            nhan_vien n
                LEFT JOIN
            hop_dong h ON n.ma_nhan_vien = h.ma_nhan_vien
        WHERE
            YEAR(h.ngay_lam_hop_dong) IN (2019 ,2020, 2021));

-- 17.Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
SELECT 
    k.ma_khach_hang,
    k.ho_ten,
    k.ma_loai_khach,
    SUM(d.chi_phi_thue + hd.so_luong * dv.gia)
FROM
    khach_hang k
        JOIN
    hop_dong h ON k.ma_khach_hang = h.ma_khach_hang
        JOIN
    dich_vu d ON h.ma_dich_vu = d.ma_dich_vu
        JOIN
    hop_dong_chi_tiet hd ON h.ma_hop_dong = hd.ma_hop_dong
        JOIN
    dich_vu_di_kem dv ON hd.ma_dich_vu_di_kem = dv.ma_dich_vu_di_kem
WHERE
    YEAR(h.ngay_lam_hop_dong) = 2021
GROUP BY k.ma_khach_hang
HAVING SUM(d.chi_phi_thue + hd.so_luong * dv.gia) > 10000000;

-- 18.Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
SELECT 
    k.ma_khach_hang, k.ho_ten
FROM
    khach_hang k
        JOIN
    hop_dong h ON k.ma_khach_hang = h.ma_khach_hang
WHERE
    YEAR(h.ngay_lam_hop_dong) < 2021;

-- 19.Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
SELECT 
    dv.ma_dich_vu_di_kem, dv.ten_dich_vu_di_kem
FROM
    dich_vu_di_kem dv
        JOIN
    hop_dong_chi_tiet hd ON dv.ma_dich_vu_di_kem = hd.ma_dich_vu_di_kem
        JOIN
    hop_dong h ON hd.ma_hop_dong = h.ma_hop_dong
WHERE
    YEAR(h.ngay_lam_hop_dong) = 2020
GROUP BY dv.ma_dich_vu_di_kem
HAVING SUM(hd.so_luong) > 10;

-- 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), 
-- ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT 
    n.ma_nhan_vien AS id,
    n.ho_ten,
    n.email,
    n.so_dien_thoai,
    n.ngay_sinh,
    n.dia_chi
FROM
    nhan_vien n 
UNION ALL SELECT 
    k.ma_khach_hang,
    k.ho_ten,
    k.email,
    k.so_dien_thoai,
    k.ngay_sinh,
    k.dia_chi
FROM
    khach_hang k;

-- 21.Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng” và 
-- đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “4/2021”.
CREATE VIEW v_nhan_vien AS
    SELECT 
        n.*
    FROM
        nhan_vien n
            JOIN
        hop_dong h ON n.ma_nhan_vien = h.ma_nhan_vien
    WHERE
        n.dia_chi LIKE '%Đà Nẵng'
            AND YEAR(h.ngay_lam_hop_dong) = 2021
            AND MONTH(h.ngay_lam_hop_dong) = 4;
SELECT 
    *
FROM
    v_nhan_vien;
    
-- 22.Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu”
--  đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
UPDATE v_nhan_vien 
SET 
    dia_chi = 'Liên Chiểu'
WHERE
    dia_chi LIKE '%Đà Nẵng';

-- 23.Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó 
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
delimiter //
create procedure sp_xoa_khach_hang(in ma_khach_hang int)
begin
delete from khach_hang k
where k.ma_khach_hang=ma_khach_hang;
end //
delimiter ;

-- 24.Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với 
-- yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure sp_them_moi_hop_dong(
in ma_hop_dong int ,
in ngay_lam_hop_dong datetime,
in ngay_ket_thuc datetime,
in tien_dat_coc double,
in ma_nhan_vien int,
in ma_khach_hang int,
in ma_dich_vu int)
begin
insert into hop_dong value(
ma_hop_dong,
ngay_lam_hop_dong,
ngay_ket_thuc,
tien_dat_coc,
ma_nhan_vien,
ma_khach_hang,
ma_dich_vu);
end //
delimiter ;

-- 25.Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị 
-- tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.


