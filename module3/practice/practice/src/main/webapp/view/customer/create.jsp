<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>ID</th>
                <td>
                    <input type="number" name="id" size="15"/>
                </td>
            </tr>

            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="Name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Birthday</th>
                <td>
                    <input type="date" name="Birthday" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>
                    <input type="radio" name="Gender" value="true"/>Nam<input type="radio" name="Gender" value="false"/>Nữ
                </td>
            </tr>
            <tr>
                <th>IdCard</th>
                <td>
                    <input type="text" name="IdCard" size="15"/>
                </td>
            </tr>
            <tr>
                <th>PhoneNumber</th>
                <td>
                    <input type="text" name="PhoneNumber" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="Email" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td>
                    <input type="text" name="Address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>CustomerType</th>
                <td>
                    <input type="text" name="CustomerType" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    <p>${mess}</p>
    <h2>
        <button onclick="location.href='/furama?action=showCustomer'">List All Customer</button>
    </h2>
</div>
</body>
</html>
