<html >
<%@page pageEncoding="UTF-8" %>
<body>
<h2>Hello World!</h2><br>
<a href="main1">mian1</a>&nbsp;&nbsp;
<a href="main2">mian2</a>

<div>
    <h3>file upload</h3>
    <form action="fileUpload" enctype="multipart/form-data" method="post">
        <input type="file" name="file1" placeholder="请选择图片"/><br>
        <input type="text" name="desc" placeholder="图片描述"/><br>
        <input type="submit" value="文件上传"/>
    </form>
</div>
</body>
</html>
