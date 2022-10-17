use quan_li_ban_hang;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id,o_date,o_total_price from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng
select customer.`name` from customer
inner join `order` on customer.c_id=`order`.c_id
group by `name`;

-- danh sách sản phẩm được mua bởi các khách
select p_name from product 
inner join order_detail on product.p_id=order_detail.p_id
group by p_name;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được 
-- tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
