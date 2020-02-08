<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>RBAC权限控制平台</title>
<%
    //front_war
    String path = request.getContextPath();
    //http://localhost:8080/front_war/
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<link rel="stylesheet" href="<%=path%>/statics/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/statics/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path%>/statics/css/main.css">
<link rel="stylesheet" href="<%=path%>/statics/layer/theme/default/layer.css">
<style>
    .tree li {
        list-style-type: none;
        cursor: pointer;
    }

    .tree-closed {
        height: 40px;
    }

    .tree-expanded {
        height: auto;
    }
</style>
<script src="<%=path%>/statics/jquery/jquery-2.1.1.min.js"></script>
<script src="<%=path%>/statics/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/statics/script/docs.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });
</script>
<script type="text/javascript" src="<%=path%>/statics/layer/layer.js"></script>
