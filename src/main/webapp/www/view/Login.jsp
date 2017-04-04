<%--
  Created by IntelliJ IDEA.
  User: roy
  Date: 2017/3/23
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
用户登入:<br>

<form action="userLogin" method="get">
    <input type="text" name="name" placeholder="用户名"><br>
    <input type="password" name="pwd" placeholder="密码"><br>
    <input type="hidden" name="goUrl" value="${goUrl}">
    <input type="submit" value="登录"/>
</form>
</body>
</html>
