<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/12 0012
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<center>
  <form action="/login" method="post">
    用户名：<input type="text" name="username"/><br>
    密&nbsp;码：<input type="password" name="password"/><br>
    <input type="submit" value="登录"/>
  </form>
</center>
</body>
</html>
