<%--
  Created by IntelliJ IDEA.
  User: leha2
  Date: 28.11.2018
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="../style/loginStyle.css">
    <meta charset="UTF-8">
    <title> login page</title>
</head>

<body>
<jsp:include page="../fragments/mainHeader.jsp"/>


<div class="loginLabel">
    <h1>login</h1>
    <form class="loginForm" action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">

        <div class="inputText">
            <input type="text" id="username" name="username" placeholder="username">
        </div>

        <div class="inputText">
            <input type="password" id="password" name="password" placeholder="password">
        </div>

        <div class="submitButton">
            <input type="submit" value="log in">
        </div>
    </form>
</div>

</body>
</html>
