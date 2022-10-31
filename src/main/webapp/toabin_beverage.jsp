<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sanit
  Date: 3/8/22
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Teeradet Panklai 63130500061--%>
<html>
<head>
    <title>ToaBin Beverage</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
     <h1>ToaBin Beverage</h1>
     <c:choose>
         <c:when test="${account == null}">
            <a class="login button" href="account">Login</a>
         </c:when>
         <c:otherwise>
             <a class="login" href="basket"> Account: ${account.mobileNo}</a><br>
             <span class="logger login">(Last buy at ${account.lastBuy})</span>
         </c:otherwise>
     </c:choose>
    <div class="grid-container">
    <c:forEach items="${drinks}" var="drink">
        <div class="menu">
            <span><img src="images/${drink.drink}.png" width="132px" height="168px"></span>
            <span>${drink.drink} ( ${drink.price} ) <a class="button" href="basket?action=buy&id=${drink.id}">Buy</a></span>

        </div>
    </c:forEach>
    </div>
</body>
</html>
