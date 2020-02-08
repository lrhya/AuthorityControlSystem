<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/2/8
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RBAC权限控制平台</title>
    <%
        //front_war
        String path = request.getContextPath();
        //http://localhost:8080/front_war/
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <!-- Custom Theme files -->
    <link href="<%=path%>/statics/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
</head>
<body>
<div class="login">
    <h2>AuthorityControlSystem</h2>
    <div class="login-top">
        <h1>LOGIN FORM</h1>
        <p style=" font-size: 12px; color: red; text-align: center">${requestScope.MESSAGE }</p>
        <form  id="login"   action="user/do/login">
            <input type="text" name="loginAcct" value="User Id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Id';}">
            <input type="text"  name="userPswd" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
        </form>
        <div class="forgot">
            <a href="#">forgot Password</a>
            <input type="button" value="Login" onclick="document.getElementById('login').submit();">
        </div>
    </div>
    <div class="login-bottom">
        <h3>New User &nbsp;<a href="#">Register</a>&nbsp Here</h3>
    </div>
</div>
<div class="copyright">
    <p>Copyright &copy; 2020.Company name All rights reserved.<a target="_blank" href="#">
    </a> - More <a href="#" target="_blank" title="#"></a></p>
</div>
</body>
