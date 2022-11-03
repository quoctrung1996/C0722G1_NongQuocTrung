<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03/11/2022
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div style="width: 100%;background-color: silver"><h1 style="text-align: center;line-height: 50px;">Danh sách dịch vụ</h1></div>
<table class="table table-striped">
    <tr style="background-color: silver">
        <th>id</th>
        <th>Tên dịch vụ</th>
        <th>Diện tích sử dụng </th>
        <th> Chi phí thuê </th>
        <th>Số lượng người tối đa </th>
        <th>Tiêu chuẩn phòng </th>
        <th>Mô tả tiện nghi khác </th>
        <th>Diện tích hồ bơi</th>
        <th>Số tầng </th>
        <th>Dịch vụ miễn phí đi kèm </th>
        <th>Kiểu thuê</th>
        <th>Mã loại dịch vụ</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="facility" items="${facilityList}">
        <tr>
            <td>${facility.getId()}</td>
            <td>${facility.getName()}</td>
            <td>${facility.getArea()}</td>
            <td>${facility.getCost()}</td>
            <td>${facility.getMax_people()}</td>
            <td>${facility.getStandard_room()}</td>
            <td>${facility.getDescription_other_convenience()}</td>
            <td>${facility.getPool_area()}</td>
            <td>${facility.getNumber_of_floors()}</td>
            <td>${facility.getFacility_free()}</td>
            <td>${facility.getRent_type_id()}</td>
            <td>${facility.getFacility_type_id()}</td>
            <td><button type="button" class="btn btn-warning">Edit</button></td>
            <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>

                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Do you want to delete?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">OK</button>
                            </div>
                        </div>
                    </div>
                </div></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
