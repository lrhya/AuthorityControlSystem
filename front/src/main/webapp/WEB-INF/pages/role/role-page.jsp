<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/2/10
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <%
        //front_war
        String path = request.getContextPath();
    %>
    <%@ include file="/WEB-INF/pages/common/include-head.jsp"%>
    <link rel="stylesheet" href="<%=path%>/statics/css/pagination.css" />
    <link rel="stylesheet" href="<%=path%>/statics/ztree/zTreeStyle.css" />
    <script type="text/javascript" src="<%=path%>/statics/ztree/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="<%=path%>/statics/script/jquery.pagination.js"></script>

</head>
<body>

<%@ include file="/WEB-INF/pages/common/include-nav.jsp"%>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/pages/common/include-sidebar.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="glyphicon glyphicon-th"></i> 数据列表
                    </h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float: left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="keywordInput" class="form-control has-success" type="text"
                                       placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="searchBtn" type="button" class="btn btn-warning">
                            <i class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button id="batchRemoveBtn" type="button" class="btn btn-danger"
                            style="float: right; margin-left: 10px;">
                        <i class=" glyphicon glyphicon-remove"></i> 批量删除
                    </button>
                    <button id="addBtn" type="button" class="btn btn-primary"
                            style="float: right;">
                        <i class="glyphicon glyphicon-plus"></i> 新增
                    </button>
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
                                   <tr>
                                        <td>1</td>
                                        <td><input type="checkbox"></td>
                                        <td>PM - 项目经理</td>
                                        <td>
                                            <button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>
                                            <button type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>
                                            <button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>
                                        </td>
                                    </tr>
                                    </tbody>
                            <tbody id="roleTableBody"></tbody>
                                         <tfoot>
                                             <tr >
                                                 <td colspan="6" align="center">
                                                     <ul class="pagination">
                                                         <li class="disabled"><a href="#">上一页</a></li>
                                                         <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                                         <li><a href="#">2</a></li>
                                                         <li><a href="#">3</a></li>
                                                         <li><a href="#">4</a></li>
                                                         <li><a href="#">5</a></li>
                                                         <li><a href="#">下一页</a></li>
                                                     </ul>
                                                 </td>
                                             </tr>
                                             </tfoot>
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
