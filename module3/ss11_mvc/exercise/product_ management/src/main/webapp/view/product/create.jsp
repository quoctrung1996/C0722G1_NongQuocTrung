<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04/11/2022
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang thêm mới</h1>
<a style="text-decoration: none" href="/controller-productServlet">Quay lại danh sách sản phẩm</a>
<form action="/controller-productServlet?action=add "method="post">
    <pre>ID:           <input type="text" name="id"></pre>
    <pre>Tên sản phẩm: <input type="text" name="name"></pre>
    <pre>Giá sản phẩm: <input type="number" name="price"></pre>
    <pre>Mô tả:        <input type="text" name="review"></pre>
    <pre>Nhà sản suất: <input type="text" name="producer"></pre>
    <pre><button>Lưu</button></pre>
</form>
<c:if test="${mess!=null}">
    <span style="color: red">${mess}</span>
</c:if>
</body>
</html>
