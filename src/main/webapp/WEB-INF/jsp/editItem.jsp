<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/10 0010
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
  <title>修改商品信息</title>
</head>
<body>
您好！${username}
<c:if test="${username != null}">
  <a href="${pageContext.request.contextPath }/logout">
    退出
  </a>
</c:if>
<!-- 显示错误信息 -->
<c:if test="${errors!=null }">
  <center>
  <c:forEach items="${errors }" var="error">
    <span style="color:red;">${error.defaultMessage}</span><br/>
  </c:forEach>
  </center>
</c:if>

<form id="itemForm"
      action="${pageContext.request.contextPath }/editItems"
      method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${items.id }"/>
  修改商品信息：
  <table width="100%" border=1>
    <tr>
      <td>商品名称</td>
      <td><input type="text" name="name" value="${items.name }"/></td>
    </tr>
    <tr>
      <td>商品价格</td>
      <td><input type="text" name="price" value="${items.price }"/></td>
    </tr>
    <tr>
      <td>商品生产日期</td>
      <td>
        <input type="text" name="createtime"
               value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
      </td>
    </tr>
    <tr>
      <td>商品图片</td>
      <td>
        <c:if test="${items.pic != null}">
          <img src="${pageContext.request.contextPath}${items.pic}" width=100 height=100/>
          <input type="hidden" name="pic" value="${items.pic}"/>
          <br/>
        </c:if>
        <input type="file"  name="items_pic"/>
      </td>
    </tr>
    <tr>
      <td>商品简介</td>
      <td>
        <textarea rows="3" cols="30" name="detail">
        ${items.detail }</textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="提交"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>