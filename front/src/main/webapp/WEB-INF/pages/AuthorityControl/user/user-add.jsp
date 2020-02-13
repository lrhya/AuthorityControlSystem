<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/2/9
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%
        //front_war
        String path = request.getContextPath();
    %>
    <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-head.jsp"%>
</head>
<body>

<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-nav.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-sidebar.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="main/to/page">首页</a></li>
                <li><a href="user/to/page">数据列表</a></li>
                <li class="active">新增</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">
                    表单数据
                </div>
                <div class="panel-body">
                    <form action="user/to/save" method="post" role="form">
                        <div class="form-group">
                            <label for="InputLoginAcct">登录账号</label>
                            <input
                                    type="text"
                                    name="loginAcct"
                                    class="form-control"
                                    id="InputLoginAcct"
                                    placeholder="请输入登陆账号"/>
                        </div>
                        <div class="form-group">
                            <label for="InputPassword">登录密码</label>
                            <input
                                    type="text"
                                    name="userPswd"
                                    class="form-control"
                                    id="InputPassword"
                                    placeholder="请输入登录密码"/>
                        </div>
                        <div class="form-group">
                            <label for="InputUsername">用户昵称</label>
                            <input
                                    type="text"
                                    name="userName"
                                    class="form-control"
                                    id="InputUsername"
                                    placeholder="请输入用户昵称"/>
                        </div>
                        <div class="form-group">
                            <label for="InputEmail">邮箱地址</label>
                            <input
                                    type="email"
                                    name="userEmail"
                                    class="form-control"
                                    id="InputEmail"
                                    placeholder="请输入邮箱地址"/>
                        </div>
                        <div class="form-group">
                            <label for="InputDepartf">所在组织</label>
                            <input
                                    type="text"
                                    name="departFather"
                                    class="form-control"
                                    id="InputDepartf"
                                    placeholder="请输入所在组织"/>
                        </div>
                        <div class="form-group">
                            <label for="InputDeparts">所属部门</label>
                            <input
                                    type="text"
                                    name="departSon"
                                    class="form-control"
                                    id="InputDeparts"
                                    placeholder="请输入所属部门"/>
                        </div>
                        <button type="submit" class="btn btn-success">
                            <i class="glyphicon glyphicon-plus"></i> 新增
                        </button>
                        <button type="reset" class="btn btn-danger">
                            <i class="glyphicon glyphicon-refresh"></i> 重置
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

