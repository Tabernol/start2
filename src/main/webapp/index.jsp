<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<div class="form">
    <h1>Enter to ...</h1><br>
    <form method="post" action="">
        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="submit">
    </form>
</div>
<%--<a href="c:url value='/in' />"> in</a> <br>--%>
<br>

<a href="<c:url value='/sub' />">SUB</a>
<hr>
<a href="hello-servlet">Hello Servlet</a>
<hr>
</body>
</html>