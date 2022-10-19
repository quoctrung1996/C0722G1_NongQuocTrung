use furama_resort;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and char_length(ho_ten)<=15;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang 
where ((year(curdate()) - year(ngay_sinh))between 18 and 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select k.ma_khach_hang,k.ho_ten,count(ma_hop_dong) as so_lan_dat_phong
from khach_hang k
inner join hop_dong h on k.ma_khach_hang=h.ma_khach_hang
where k.ma_loai_khach=1
group by ma_khach_hang
order by count(ma_hop_dong);

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
--  tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là 
-- từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng.
--  (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select 
k.ma_khach_hang,
k.ho_ten,
l.ten_loai_khach,
h.ma_hop_dong,
d.ten_dich_vu,
h.ngay_lam_hop_dong,
h.ngay_ket_thuc,
sum(d.chi_phi_thue+hd.so_luong*dv.gia) as tong_tien from loai_khach l

join khach_hang k  on k.ma_loai_khach=l.ma_loai_khach
left join hop_dong h on k.ma_khach_hang=h.ma_khach_hang
left join dich_vu d on h.ma_dich_vu=d.ma_dich_vu
left join hop_dong_chi_tiet hd on h.ma_hop_dong=hd.ma_hop_dong
left join dich_vu_di_kem dv on hd.ma_dich_vu_di_kem=dv.ma_dich_vu_di_kem
group by k.ma_khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select 
d.ma_dich_vu,
d.ten_dich_vu,
d.dien_tich,
d.chi_phi_thue,
l.ten_loai_dich_vu,
h.ngay_lam_hop_dong
from dich_vu d 
left join loai_dich_vu l on d.ma_loai_dich_vu=l.ma_loai_dich_vu
 join hop_dong h on d.ma_dich_vu=h.ma_dich_vu
where d.ma_dich_vu not in(
select d.ma_dich_vu from hop_dong 
where month(h.ngay_lam_hop_dong) in(1,2,3)and year(h.ngay_lam_hop_dong)= '2021')
group by d.ma_dich_vu;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue,
--  ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select 
d.ma_dich_vu,
d.ten_dich_vu,
d.dien_tich,
d.so_nguoi_toi_da,
d.chi_phi_thue,
l.ten_loai_dich_vu
from dich_vu d 
join loai_dich_vu l on d.ma_loai_dich_vu=l.ma_loai_dich_vu
join hop_dong h on d.ma_dich_vu=h.ma_dich_vu
where h.ma_dich_vu not in(
select h.ma_dich_vu from hop_dong h
where year(ngay_lam_hop_dong)=2021) and year(h.ngay_lam_hop_dong)=2020
group by d.ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
--  Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- cach1:
select distinct ho_ten from khach_hang;
-- cach2:
select ho_ten from khach_hang
group by ho_ten;
-- cach3:
select ho_ten from khach_hang
union 
select ho_ten from khach_hang;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(ngay_lam_hop_dong) as thang,count(ngay_lam_hop_dong) as so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong)=2021
group by month(ngay_lam_hop_dong)
order by thang;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem
--  (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select 
h.ma_hop_dong,
h.ngay_lam_hop_dong,
h.ngay_ket_thuc,
h.tien_dat_coc,
count(hd.ma_dich_vu_di_kem) as so_luong_dich_vu_di_kem
from hop_dong_chi_tiet hd 
right join hop_dong h on hd.ma_hop_dong=h.ma_hop_dong
left join dich_vu_di_kem dv on hd.ma_dich_vu_di_kem=dv.ma_dich_vu_di_kem
group by h.ma_hop_dong;

-- 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng
--  có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.


