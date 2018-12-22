<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="user.label.login" var="logIn"/>
<fmt:message bundle="${naming}" key="user.label.login.placeholder" var="placeLogin"/>
<fmt:message bundle="${naming}" key="user.label.password.placeholder" var="placePassword"/>
<fmt:message bundle="${naming}" key="user.label.login" var="logIn"/>
<fmt:message bundle="${naming}" key="login.label.wrongParams" var="wrongParams"/>

<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/loginStyle.css" type="text/css">
    <title>${logIn}</title>
</head>

<body>
<div class="loginLabel">
    <img src="img/user4.jpg"/>
    <form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
        <div class="loginForm">
            <div class="inputText">
                <input type="text" id="username" name="username" placeholder=${placeLogin}>
            </div>

            <div class="inputText">
                <input type="password" id="password" name="password" placeholder=${placePassword}>
            </div>
            <c:if test="${not empty errorMessage}">
                <div class="wrongParametres">
                    <label>${wrongParams}</label>
                </div>
            </c:if>
            <div class="submitButton">
                <input class="submitBtn" type="submit" value=${logIn}>
            </div>
        </div>
    </form>
</div>

</body>
</html>
