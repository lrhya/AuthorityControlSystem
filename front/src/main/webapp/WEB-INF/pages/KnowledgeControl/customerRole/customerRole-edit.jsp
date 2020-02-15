<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/1/8
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-head.jsp"%>
</head>

<body>
<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="customer/to/main/page">首页</a></li>
                <li><a href="customer/query/for/search">数据列表</a></li>
                <li class="active">更新</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">
                    表单数据
                </div>
                <div class="panel-body">

                    <form:form action="customerRole/update" method="post" modelAttribute="customerRole">
                        <!-- 模型对象中包含的属性可以使用form:hidden -->
                        <form:hidden path="tId"/>

                        <!-- 模型对象中没有的属性不能使用form:hidden -->
                        <input type="hidden" name="pageNum" value="${param.pageNum }" />

                        <div class="form-group">
                            <label for="exampleInputPassword1">id</label>
                            <form:input path="tId" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">角色</label>
                            <form:input path="tName" cssClass="form-control"/>
                        </div>
                        <button type="submit" class="btn btn-success">
                            <i class="glyphicon glyphicon-edit"></i> 更新
                        </button>
                        <button type="reset" class="btn btn-danger">
                            <i class="glyphicon glyphicon-refresh"></i> 重置
                        </button>
                    </form:form>


                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>
