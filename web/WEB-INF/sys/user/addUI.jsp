<%--
  Created by IntelliJ IDEA.
  User: liujie
  Date: 2017/2/24
  Time: 上午8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>初始化系统管理账户</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/sys_user_add.action" method="post">

    <p>初始化用户名</p>
   <input type="text" name="user.account"/>

    <p>初始化密码</p>
   <input type="text" name="user.password"/>

    <input type="submit" value="提交"/>

</form>
</body>
</html>
