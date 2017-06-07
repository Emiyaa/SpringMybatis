<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/9 0009
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查询商品列表</title>
</head>
<body>
您好！${username}
<c:if test="${username != null}">
  <a href="${pageContext.request.contextPath }/logout">
    退出
  </a>
</c:if>
<center>
  <form action="${pageContext.request.contextPath}/queryItems"
        method="post">
    查询条件:
    <table width="100%" border="1">
      <tr>
        <td>
          商品名称:<input type="text" name="itemsCustom.name"/>
        </td>
        <td>
          <input type="submit" value="查询"/>
        </td>
      </tr>
    </table>
    商品列表:
    <table width="100%" border="1">
      <tr>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>生产日期</td>
        <td>商品描述</td>
        <td>操作</td>
      </tr>
      <c:forEach items="${itemsList}" var="item">
        <tr>
          <td>${item.name}</td>
          <td>${item.price}</td>
          <td>
            <fmt:formatDate value="${item.createtime}"
            pattern="yyyy-MM-dd HH:mm:ss"/>
          </td>
          <td>${item.detail}</td>
          <td>
            <a href="${pageContext.request.contextPath}/editItem?id=${item.id}">修改</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </form>
</center>
</body>
</html>
