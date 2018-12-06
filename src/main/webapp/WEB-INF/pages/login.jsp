<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/loginStyle.css" type="text/css">
    <title> login page</title>
</head>

<body>
<%--<jsp:include page="../fragments/mainHeader.jsp"/>--%>

<div class="loginLabel">
    <img src="img/user4.jpg"/>
    <form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
        <div class="loginForm">
            <div class="inputText">
                <input type="text" id="username" name="username" placeholder="username">
            </div>

            <div class="inputText">
                <input type="password" id="password" name="password" placeholder="password">
            </div>

            <div class="submitButton">
                <input class="submitBtn" type="submit" value="log in">
            </div>

        </div>
    </form>
</div>

</body>
</html>
