<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/1/31
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <head>
        <%
       //front_war
        String path = request.getContextPath();
         %>
    <%@ include file="/WEB-INF/pages/AuthorityControl/common/include-head.jsp" %>
    <link rel="stylesheet" href="<%=path%>/statics/ztree/zTreeStyle.css"/>
    <script type="text/javascript" src="<%=path%>/statics/ztree/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript" src="<%=path%>/statics/script/my-menu.js" charset="utf-8"></script>
    <script type="text/javascript">
        $(function(){
        //页面加载完成前加载
        initWholeTree();

        $("#menuAddBtn").click(function () {
            // 收集表单填写的数据
            var name = $.trim($("#menuAddModal [name='name']").val());
            var url = $.trim($("#menuAddModal [name='url']").val());
            var icon = $("#menuAddModal [name='icon']:checked").val();

            if (name == null || name == "") {
                layer.msg("请填写菜单项名称！");
                return;
            }

            if (url == null || url == "") {
                layer.msg("请填写菜单项对应的访问地址！");
                return;
            }

            // 发送Ajax请求
            $.ajax({
                "url": "menu/save.json",
                "type": "post",
                "dataType": "json",
                "data": {
                    "name": name,
                    "url": url,
                    "pid": window.menuId,	// 当前操作的节点是新节点的父节点
                    "icon": icon
                },
                "success": function (response) {

                    var result = response.result;

                    if (result == "SUCCESS") {
                        layer.msg("操作成功！");

                        initWholeTree();
                    }

                    if (result == "FAILED") {
                        layer.msg(response.message);
                    }

                },
                "error": function (response) {
                    layer.msg(response.message);
                }
            });

            $("#menuAddModal").modal("hide");
        });

        $("#menuEditBtn").click(function(){

            // 收集表单填写的数据
            var name = $.trim($("#menuEditModal [name='name']").val());
            var url = $.trim($("#menuEditModal [name='url']").val());
            var icon = $("#menuEditModal [name='icon']:checked").val();

            if(name == null || name == "") {
                layer.msg("请填写菜单项名称！");
                return ;
            }

            if(url == null || url == "") {
                layer.msg("请填写菜单项对应的访问地址！");
                return ;
            }

            // 发送Ajax请求
            $.ajax({
                "url":"menu/update.json",
                "type":"post",
                "dataType":"json",
                "data":{
                    "id":window.menuId,
                    "pid":window.menuPid,
                    "name":name,
                    "url":url,
                    "icon":icon
                },
                "success":function(response){

                    var result = response.result;

                    if(result == "SUCCESS") {
                        layer.msg("操作成功！");

                        initWholeTree();
                    }

                    if(result == "FAILED") {
                        layer.msg(response.message);
                    }

                },
                "error":function(response){
                    layer.msg(response.message);
                }
            });

            $("#menuEditModal").modal("hide");
        });

        $("#menuRemoveBtn").click(function(){

            $.ajax({
                "url":"menu/remove/"+window.menuId+".json",
                "type":"post",
                "data":{"random":Math.random()},
                "dataType":"json",
                "success":function(response){

                    if(response.result == "SUCCESS") {

                        layer.msg("操作成功！");

                        initWholeTree();
                    }

                    if(response.result == "FAILED") {
                        layer.msg(response.message);
                    }

                },
                "error":function(response){
                    layer.msg(response.message);
                }
            });

            // 后续操作
            $("#menuConfirmModal").modal("hide");

        });
        });
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
                    <i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
                    <div style="float: right; cursor: pointer;" data-toggle="modal"
                         data-target="#myModal">
                        <i class="glyphicon glyphicon-question-sign"></i>
                    </div>
                </div>
                <div class="panel-body">
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/pages/AuthorityControl/menu/include-modal-menu-add.jsp" %>
<%@ include file="/WEB-INF/pages/AuthorityControl/menu/include-modal-menu-edit.jsp" %>
<%@ include file="/WEB-INF/pages/AuthorityControl/menu/include-modal-menu-confirm.jsp" %>
</body>
</html>
