<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04/11/2022
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a style="text-decoration: none;float: left" href="/controller-productServlet?action=add">
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Thêm mới
    </button>
</a>
<div style="float: right;margin-right: 100px">
    <form action="/controller-productServlet?action=search" method="post">
        <input type="text" placeholder="tên sản phẩm" name="name">
        <span> <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Tìm kiếm
    </button></span>
    </form>
</div>

<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm</th>
        <th>Mô tả</th>
        <th>Nhà sản xuất</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getReview()}</td>
            <td>${product.getProducer()}</td>
            <td>
                <a href="/controller-productServlet?action=view&id=${product.getId()}">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        View
                    </button>
                </a>
            </td>
            <td>
                    <%--                <button type="button" class="btn btn-warning">Edit</button>--%>
                <button onclick="infoEdit('${product.getId()}')" type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    Edit
                </button>
            </td>
            <td>
                <button onclick="infoDelete('${product.getId()}')" type="button" class="btn btn-danger"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/controller-productServlet?action=edit"method="post">
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
     tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">
                    Edit product by id=
                    <input type="text" id="editId" name="editId" style="width: 30px" >
                   </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
                <div class="modal-body">
                    <pre>Tên sản phẩm: <input type="text" name="name" value="${product.getName()}"></pre>
                    <pre>Giá sản phẩm: <input type="number" name="price" value="${product.getPrice()}"></pre>
                    <pre>Mô tả:        <input type="text" name="review" value="${product.getReview()}"></pre>
                    <pre>Nhà sản suất: <input type="text" name="producer" value="${product.getProducer()}"></pre>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát
                    </button>
                    <button type="submit" class="btn btn-primary">Sửa</button>
                </div>
        </div>
    </div>
</div>
</form>


<form  action="/controller-productServlet?action=delete"
       method="post">
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Do you want to delete id=
                <input id="deleteId" name="deleteId" type="text" style="width: 30px">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                </button>
                    <%--                                    <input type="submit" value="OK">--%>
                    <button class="btn btn-primary">OK</button>
            </div>
        </div>
    </div>
</div>
</form>
<script>
    function infoDelete(id) {
        document.getElementById("deleteId").value = id;
    }
    function infoEdit(id){
        document.getElementById("editId").value = id;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
