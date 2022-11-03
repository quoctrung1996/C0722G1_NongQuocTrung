<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03/11/2022
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h1>Simple Calculator</h1>
 <form action="/CalculatorServlet" method="post">
     <span>First operand</span>
     <input type="text" name="number1"><br><br>
     <span>Operator</span>
     <select name="operator" id="">
         <option value="+">Addition</option>
         <option value="-">Subtraction</option>
         <option value="*">Multiplication</option>
         <option value="/">Division</option>
     </select><br><br>
     <span>Second operator</span>
     <input type="text" name="number2"><br><br>
     <button>Calculator</button>
 </form>
  </body>
</html>
