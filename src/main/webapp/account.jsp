<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: sanit
  Date: 3/8/22
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Teeradet Panklai 63130500061--%>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>Transaction History</h1>
    <a class="button" href="beverage-list"> &lt; </a> &nbsp;&nbsp; <a class="button" href="account?action=logout">Logout</a>
    <table>
        <tr>
            <th>Account No</th>
            <td colspan="2">${account.mobileNo}</td>
        </tr>
        <tr>
            <th>Last Buy</th>
            <td colspan="2"><fmt:formatDate value="${account.lastBuy}" pattern="dd-MMM-yyyy"/></td>
        </tr>
        <tr>
            <th>Total amount</th>
            <td colspan="2">${account.totalAmount}</td>
        </tr>
        <tr>
            <th>Tran Date</th>
            <th>Drink (quantity)</th>
            <th class="center">Amount</th>
        </tr>
        <c:forEach items="${account.transactions}" var="transaction">
            <tr>
                <td><fmt:formatDate value="${transaction.tranDate}" pattern="dd-MMM-yyyy"/></td>
                <td>${transaction.drinkId.drink} (1 unit)</td>
                <td class="center">${transaction.amount}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
