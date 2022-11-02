<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02/11/2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/display" method="post">
    <label>Product Description:</label><br>
    <input type="text" name="product_description"><br>
    <label>List Price:</label><br>
    <input type="text" name="list_price"><br>
    <label>Discount Percent:</label><br>
    <input type="text" name="discount_percent"><br><br>
    <input type = "submit" id = "submit" value="Calculate Discount">
  </form>
  </body>
</html>
