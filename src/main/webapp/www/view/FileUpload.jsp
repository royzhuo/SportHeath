<%--
  Created by IntelliJ IDEA.
  User: Roy
  Date: 17/5/16
  Time: 上午12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>饮食上传</h1>

<form action="/sport/api/food/upload" method="post" enctype="multipart/form-data">
    食品名字:<input type="text" name="foodName" placeholder="请输入食品名称"/><br>
    选择食品图片:<input type="file" name="foodFile" placeholder="请输入食品名称"/><br>
    营养:<input type="text" name="foodYingYang" placeholder="输入营养价值"/><br>
    <input type="submit" value="上传">
</form>

</body>
</html>
