<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/1/3
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="UTF-8">

<head>
    <%
        //front_war
        String path = request.getContextPath();
    %>
    <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-head.jsp" %>
    <link rel="stylesheet" href="<%=path%>/statics/css/pagination.css"/>
    <script type="text/javascript" src="<%=path%>/statics/script/jquery.pagination.js"></script>
    <script type="text/javascript" src="<%=path%>/statics/script/my-customerRole.js"></script>
    <script type="text/javascript">
        $(function () {

            // 初始化全局变量
            window.totalRecord = ${requestScope['PAGE-INFO'].total};
            window.pageSize = ${requestScope['PAGE-INFO'].pageSize};
            window.pageNum = ${requestScope['PAGE-INFO'].pageNum};

            // 每一次页面最初显示的时候都会把keyword设置为最新值
            window.keyword = "${param.keyword}";

            // 对分页导航条显示进行初始化
            initPagination();

            // 全选/全不选功能
            $("#summaryBox").click(function () {

                // 获取当前#summaryBox的勾选状态
                // this代表当前多选框对象（DOM对象）
                // checked属性为true时表示被勾选，为false时表示没有被勾选
                // 使用checkStatus设置.itemBox的状态
                $(".itemBox").prop("checked", this.checked);
            });

        })



    </script>
</head>
<body>

<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="glyphicon glyphicon-th"></i> 数据列表
                    </h3>
                </div>
                <div class="panel-body">
                    <form action="customerRole/to/page" class="form-inline" role="form" style="float: left;"
                          method="post">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input
                                        name="keyword"
                                        class="form-control has-success"
                                        type="text"
                                        placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-warning">
                            <i class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button
                            id="batchRemoveBtn"
                            type="button"
                            class="btn btn-danger"
                            style="float: right; margin-left: 10px;">
                        <i class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <a href="customer/to/add/page" class="btn btn-primary" style="float: right;"><i
                            class="glyphicon glyphicon-plus"></i> 新增</a>
                    <br>
                    <hr style="clear: both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input id="summaryBox" type="checkbox"></th>
                                <th>名称</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${empty requestScope['PAGE-INFO'].list }">
                                <tr>
                                    <td style="text-align: center;" colspan="6">抱歉！没有符合您要求的查询结果！</td>
                                </tr>
                            </c:if>
                            <c:if test="${!empty requestScope['PAGE-INFO'].list }">
                                <c:forEach items="${requestScope['PAGE-INFO'].list }"
                                           var="customerRole" varStatus="myStatus">
                                    <tr>
                                        <td>${myStatus.count }</td>
                                        <td><input customerId="${customerRole.tId }" class="itemBox" type="checkbox"></td>
                                        <td>${customerRole.tName }</td>
                                        <td>
                                            <a href="assign/to/assign/role/page.html?customerId=${customer.id }&pageNum=${requestScope['PAGE-INFO'].pageNum}"
                                               class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></a>
                                            <a href="customer/to/edit/page.html?customerId=${customer.id }&pageNum=${requestScope['PAGE-INFO'].pageNum}"
                                               class="btn btn-primary btn-xs"><i
                                                    class=" glyphicon glyphicon-pencil"></i></a>
                                            <button customerId="${customer.id }" type="button"
                                                    class="btn btn-danger btn-xs uniqueRemoveBtn">
                                                <i class=" glyphicon glyphicon-remove"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6" align="center">
                                    <div id="Pagination" class="pagination">
                                        <!-- 这里显示分页 -->
                                    </div>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
