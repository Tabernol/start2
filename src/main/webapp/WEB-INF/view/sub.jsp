<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 06.12.2022
  Time: 03:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="subject" items="${requestScope.sub}">
    <ul>
        <li>id: <c:out value="${subject.id}"/></li>

        <li>name: <c:out value="${subject.name}"/></li>
    </ul>
    <hr/>
</c:forEach>
</body>
</html>
