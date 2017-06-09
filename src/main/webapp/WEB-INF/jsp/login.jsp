<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登陆</title>
    <jsp:include page="${pageContext.request.contextPath}/js/resource/easyui.jsp"></jsp:include>
</head>
<body>
<center>

    <!-- 此处添加注册成功提示信息 -->
    <h4><font color="red">${reg_message }</font></h4>
    <h4><font color="red">${message }</font></h4>
    <%
        session.removeAttribute("message");
        session.removeAttribute("reg_message");
    %>
    <div class="easyui-panel" title="登 陆" style="width:350px;padding:30px 60px">
        <form id="form" action="${pageContext.request.contextPath }/loginTo" method="post">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="username" style="width:100%;height:28px;padding:12px"
                       data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38"><br/><br/>
                <input class="easyui-textbox" name="password" type="password"
                       style="width:100%;height:28px;padding:12px"
                       data-options="prompt:'密码输入',iconCls:'icon-lock',iconWidth:38">
            </div>
        </form>
        <div align="center">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width:28%;height:22px"
               onclick="document.getElementById('form').submit();return false">登 陆</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath }/toRegist" class="easyui-linkbutton"
               style="width:28%;height:22px">注 册</a>
        </div>
    </div>
</center>
</body>
</html>