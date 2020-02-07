<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2020/2/7
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${!empty list}">
    <c:forEach  items="${list}" var="user">
        ${user}<br/>
    </c:forEach>
</c:if>
</body>
</html>
