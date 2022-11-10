<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09/11/2022
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<%--    <table class="table table-striped">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th scope="col">Name</th>--%>
<%--            <th scope="col">Birthday</th>--%>
<%--            <th scope="col">Gender</th>--%>
<%--            <th scope="col">IdCard</th>--%>
<%--            <th scope="col">PhoneNumber</th>--%>
<%--            <th scope="col">Email</th>--%>
<%--            <th scope="col">Address</th>--%>
<%--            <th scope="col">CustomerType</th>--%>
<%--            <th scope="col"></th>--%>
<%--            <th scope="col"></th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="customer" items="${customerList}" varStatus="status">--%>
<%--            <tr>--%>
<%--                <td>${customer.getName()}</td>--%>
<%--                <td>${customer.getBirthday()}</td>--%>
<%--                <c:if test="${customer.getGender()}">--%>
<%--                    <td>Male</td>--%>
<%--                </c:if>--%>
<%--                <c:if test="${!customer.getGender()}">--%>
<%--                    <td>Female</td>--%>
<%--                </c:if>--%>
<%--                <td>${customer.getIdentityCard()}</td>--%>
<%--                <td>${customer.getPhoneNumber()}</td>--%>
<%--                <td>${customer.getEmail()}</td>--%>
<%--                <td>${customer.getAddress()}</td>--%>
<%--                <td>${customer.getCustomerType()}</td>--%>
<%--                <td><button onclick="location.href='/furama_web?action=editCustomer&id=${customer.getId()}'" type="button" class="btn btn-warning" >--%>
<%--                    Edit--%>
<%--                </button>--%>
<%--                </td>--%>
<%--                <td><button onclick="infoDelete('${customer.getId()}')" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop">--%>
<%--                    Delete--%>
<%--                </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <h3>${mess}</h3>--%>
<%--</div>--%>
<a href="/furama?action=addCustomer">Thêm mới</a>
<table class="table table-dark">
   <tr>
       <th>name</th>
       <th>birthday</th>
       <th>gender</th>
       <th>identityCard</th>
       <th>phoneNumber</th>
       <th>email</th>
       <th>address</th>
       <th>customerType</th>
       <th></th>
       <th></th>
   </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthday()}</td>
            <c:if test="${customer.getGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!customer.getGender()}">
                <td>Nữ</td>
            </c:if>
            <td>${customer.getIdentityCard()}</td>
            <td>${customer.getPhoneNumber()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getCustomerType()}</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
    </c:forEach>
</table>

<%--<form action="/furama_web?action=deleteCustomer"method="post">--%>
<%--    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="staticBackdropLabel">Delete--%>
<%--                    </h5>--%>
<%--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <p>Delete customer by id=--%>
<%--                        <input type="text"  id="deleteId" name="deleteId" value="${customer.getId()}" style="width: 30px;border: none">--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>--%>
<%--                    <button  class="btn btn-primary">Yes</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</form>--%>

<%--<script>--%>
<%--    function infoDelete(id) {--%>
<%--        document.getElementById("deleteId").value = id;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>