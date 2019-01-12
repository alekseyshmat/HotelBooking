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
<fmt:message bundle="${naming}" key="login.label.blockingAccount" var="blockingAccount"/>

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/loginStyle.css" type="text/css">
    <title>${logIn}</title>
</head>

<body>
<jsp:include page="../fragments/header/mainHeader.jsp"/>
<div class="startPageContainer">
    <%--<img src="img/user4.jpg"/>--%>
    <div class="infoLabel">
        <label class="info" for="signin">Sign in</label>
        <input id="signin" name="action" type="radio" value="signin">
        <label class="info" for="signup">Sign up</label>
        <input id="signup" name="action" type="radio" value="signup">
    </div>
    <div class="signIn">
        <form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
            <div class="loginForm">
                <div class="inputText">
                    <input type="text" id="username" name="username" placeholder="${placeLogin}"
                           pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required>
                </div>

                <div class="inputText">
                    <input type="password" id="password" name="password" placeholder="${placePassword}"
                           required>
                </div>
                <c:if test="${not empty requestScope.errorMessage}">
                    <div class="wrongParametres">
                        <c:choose>
                            <c:when test="${requestScope.errorMessage eq 'Wrong login or password'}">
                                <label>${wrongParams}</label>
                            </c:when>
                            <c:when test="${requestScope.errorMessage eq 'Your account is blocked'}">
                                <label>${blockingAccount}</label>
                            </c:when>
                        </c:choose>
                    </div>
                </c:if>
                <input class="submitBtn" type="submit" value=${logIn}>
            </div>
        </form>
    </div>
</div>

</body>
</html>
