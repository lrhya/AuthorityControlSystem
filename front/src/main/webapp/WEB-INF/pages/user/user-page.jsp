<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/2/8
  Time: 16:49
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
    <%@ include file="/WEB-INF/pages/common/include-head.jsp" %>
    <link rel="stylesheet" href="<%=path%>/statics/css/pagination.css"/>
    <script type="text/javascript" src="<%=path%>/statics/script/jquery.pagination.js"></script>

    <script type="text/javascript">
        $(function () {

            // 对分页导航条显示进行初始化
            initPagination();

        });

        // 声明函数封装导航条初始化操作
        function initPagination() {

            // 声明变量存储总记录数
            var totalRecord = ${requestScope['PAGE-INFO'].total};

            // 声明变量存储分页导航条显示时的属性设置
            var paginationProperties = {
                num_edge_entries: 3,			//边缘页数
                num_display_entries: 5,		//主体页数
                callback: pageselectCallback,	//回调函数
                items_per_page: ${requestScope['PAGE-INFO'].pageSize},	//每页显示数据数量，就是pageSize
                current_page: ${requestScope['PAGE-INFO'].pageNum - 1},//当前页页码
                prev_text: "上一页",			//上一页文本
                next_text: "下一页"			//下一页文本
            };

            // 显示分页导航条
            $("#Pagination").pagination(totalRecord, paginationProperties);
        }

        // 在每一次点击“上一页”、“下一页”、“页码”时执行这个函数跳转页面
        function pageselectCallback(pageIndex, jq) {

            // pageIndex从0开始，pageNum从1开始
            var pageNum = pageIndex + 1;

            // 跳转页面
            window.location.href = "user/to/page?pageNum=" + pageNum;

            return false;
        }


    </script>
</head>
<body>

<%@ include file="/WEB-INF/pages/common/include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/pages/common/include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="glyphicon glyphicon-th"></i> 数据列表
                    </h3>
                </div>
                <div class="panel-body">
                    <form action="user/query/for/search.html" class="form-inline" role="form" style="float: left;"
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
                    <a href="user/to/add/page.html" class="btn btn-primary" style="float: right;"><i
                            class="glyphicon glyphicon-plus"></i> 新增</a>
                    <br>
                    <hr style="clear: both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input id="summaryBox" type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
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
                                <c:forEach items="${requestScope['PAGE-INFO'].list }" var="user" varStatus="myStatus">
                                    <tr>
                                        <td>${myStatus.count }</td>
                                        <td><input type="checkbox"></td>
                                        <td>${user.loginAcct }</td>
                                        <td>${user.userName }</td>
                                        <td>${user.userEmail }</td>
                                        <td>
                                            <button type="button" class="btn btn-success btn-xs">
                                                <i class=" glyphicon glyphicon-check"></i>
                                            </button>
                                            <button type="button" class="btn btn-primary btn-xs">
                                                <i class=" glyphicon glyphicon-pencil"></i>
                                            </button>
                                            <button type="button" class="btn btn-danger btn-xs">
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