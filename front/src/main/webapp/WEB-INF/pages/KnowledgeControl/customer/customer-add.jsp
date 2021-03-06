<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/1/6
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-head.jsp"%>
</head>
<body>

<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-nav.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-sidebar.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="customer/to/main/page">首页</a></li>
                <li><a href="customer/query/for/search">数据列表</a></li>
                <li class="active">新增</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">
                    表单数据
                </div>
                <div class="panel-body">
                    <form action="customer/save.html" method="post" role="form">
                        <div class="form-group">
                            <label for="exampleInputLoginAcct">登录账号</label>
                            <input
                                    type="text"
                                    name="loginAcct"
                                    class="form-control"
                                    id="exampleInputLoginAcct"
                                    placeholder="请输入登陆账号"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword">登录密码</label>
                            <input
                                    type="text"
                                    name="userPswd"
                                    class="form-control"
                                    id="exampleInputPassword"
                                    placeholder="请输入登录密码"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputUsername">用户昵称</label>
                            <input
                                    type="text"
                                    name="userName"
                                    class="form-control"
                                    id="exampleInputUsername"
                                    placeholder="请输入用户昵称"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">邮箱地址</label>
                            <input
                                    type="email"
                                    name="email"
                                    class="form-control"
                                    id="exampleInputEmail1"
                                    placeholder="请输入邮箱地址"/>
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
