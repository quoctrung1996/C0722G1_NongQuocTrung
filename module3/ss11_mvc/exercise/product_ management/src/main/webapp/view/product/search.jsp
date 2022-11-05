<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05/11/2022
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<p>
    <a style="text-decoration: none" href="/controller-productServlet">Quay lại danh sách sản phẩm</a>
</p>
<p><c:if test="${mess!=null}">
    <span style="color: red">${mess}</span>
</c:if>
</p>
<table class="table table-striped">
    <tr>
        <td>Tên sản phẩm</td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Giá sản phẩm</td>
        <td>${product.getPrice()}</td>
    </tr>
    <tr>
        <td>Mô tả</td>
        <td>${product.getReview()}</td>
    </tr>
    <tr>
        <td>Nhà sản xuất</td>
        <td>${product.getProducer()}</td>
    </tr>
</table>
</body>
</html>
