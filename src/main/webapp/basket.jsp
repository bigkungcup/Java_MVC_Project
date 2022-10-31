<%--
  Created by IntelliJ IDEA.
  User: sanit
  Date: 3/8/22
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Teeradet Panklai 63130500061--%>
<html>
<head>
    <title>Basket</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="basket">
        <a class="back" href="beverage-list"><span>&lt;</span></a>
        <h2>Your Selected Drink</h2>
        <img src="images/${drink.drink}.png">
        <h4>Quantity : 1 unit</h4>
        <h4>Price    : ${drink.price}</h4>
        <a class="button brown" href="basket?action=buyDrink&id=${drink.id}">Buy Now</a>
    </div>
</body>
</html>
