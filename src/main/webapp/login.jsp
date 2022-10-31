<%--
  Created by IntelliJ IDEA.
  User: sanit
  Date: 3/8/22
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Teeradet Panklai 63130500061--%>
<html>
<head>
    <title>ToaBin Account</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            background-color: moccasin;
            text-align: center;
            width: 50% ;
            margin-top: 50px ;
            margin-left: auto ;
            margin-right: auto ;
        }
    </style>
</head>
<body>
<h3>ToaBin Account</h3>
<form action="account" method="post">
    <div class="field">
        <label for="mobileno">Mobile No:</label>
        <input type="text" name="mobileno" required/><br>
    </div>
    <div class="field">
        <label for="pincode">Pin Code</label>&nbsp;&nbsp;&nbsp;
        <input type="password" name="pincode" required/>
    </div>
    <div class="field">
        <input class="button" type="submit" value="Login"/>
        <a class="button" href="beverage-list">Cancel</a>
    </div>
</form>
</body>
</html>
