<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03/11/2022
  Time: 11:15
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
<div class="col-md-12 " style="background-color: silver;text-align: center;">
    <h1 style="line-height: 60px">Danh Sách Khách Hàng</h1></div>
<table class="table table-active" >
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getDayOfBirth()}</td>
            <td>${customer.getAddress()}</td>
            <td><img src="${customer.getPhoto()}" ></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
