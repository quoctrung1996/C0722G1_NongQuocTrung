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
left join hop_dong h on d.ma_dich_vu=h.ma_dich_vu
where not (year(h.ngay_lam_hop_dong)= 2021 and (month(h.ngay_lam_hop_dong) in(1,2,3,4)))
 group by d.ma_dich_vu;
  

