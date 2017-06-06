<html>
<%@page pageEncoding="UTF-8" %>
<body>
<h2>管理员登录</h2><br>
<%--<a href="main1">mian1</a>&nbsp;&nbsp;
<a href="main2">mian2</a>--%>

<div>
    <%-- <h3>file upload</h3>--%>

    <%-- <form action="fileUpload" enctype="multipart/form-data" method="post">
         <input type="file" name="file1" placeholder="请选择图片"/><br>
         <input type="text" name="desc" placeholder="图片描述"/><br>
         <input type="submit" value="文件上传"/>
     </form>--%>

    <form action="/sport/api/admin/login" method="get">
        用户名:<input type="text" name="name" placeholder="请输入管理员账户"><br>
        密 码:<input type="password" name="pwd" placeholder="请输入密码"><br>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
