<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="UTF-8">
<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-head.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#rightBtn").click(function(){
			$("#leftSelect>option:selected").appendTo("#rightSelect");
		});
		$("#leftBtn").click(function(){
			$("#rightSelect>option:selected").appendTo("#leftSelect");
		});
		$("#submitBtn").click(function(){
			
			$("#rightSelect>option").prop("selected","selected");
			
		});
	});
</script>
<body>

	<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/pages/AuthorityControl/common/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- 各个页面具体内容 -->
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">数据列表</a></li>
					<li class="active">分配课程</li>
				</ol>
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="customerRoleAssign/menu" method="post" role="form"
							class="form-inline">

							<input type="hidden" name="customerRoleId" value="${param.customerRoleId }" />
							<input type="hidden" name="pageNum" value="${param.pageNum }" />
							<div class="form-group">
								<label for="exampleInputPassword1">未分配课程列表</label><br>
								<select
									id="leftSelect" class="form-control" multiple size="20"
									style="width: 200px; overflow-y: auto;">
									<c:forEach items="${requestScope.unAssignedCustomerMenuList }" var="menu">
										<option value="${menu.id }">${menu.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<ul>
									<li id="rightBtn"
										class="btn btn-default glyphicon glyphicon-chevron-right"></li>
									<br>
									<li id="leftBtn"
										class="btn btn-default glyphicon glyphicon-chevron-left"
										style="margin-top: 20px;"></li>
								</ul>
							</div>
							<div class="form-group" style="margin-left: 40px;">
								<label for="exampleInputPassword1">已分配课程列表</label><br>
								<select
									id="rightSelect" name="customerMenuIdList" class="form-control"
									multiple size="20" style="width: 200px; overflow-y: auto;">
									
									<c:forEach items="${requestScope.assignedCustomerMenuList}" var="menu">
										<option value="${menu.id }">${menu.name }</option>
									</c:forEach>

								</select>
							</div>
							<button id="submitBtn" type="submit" style="width: 200px;"
								class="btn btn-success btn-lg btn-block">分配</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>