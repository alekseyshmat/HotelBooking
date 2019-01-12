<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="user.label.login" var="logIn"/>
<fmt:message bundle="${naming}" key="user.label.login.placeholder" var="placeLogin"/>
<fmt:message bundle="${naming}" key="user.label.password.placeholder" var="placePassword"/>
<fmt:message bundle="${naming}" key="user.label.login" var="logIn"/>
<fmt:message bundle="${naming}" key="table.label.firstName" var="firstName"/>
<fmt:message bundle="${naming}" key="table.label.lastName" var="lastName"/>
<fmt:message bundle="${naming}" key="table.label.birthday" var="birthday"/>
<fmt:message bundle="${naming}" key="table.label.email" var="email"/>
<fmt:message bundle="${naming}" key="login.label.wrongParams" var="wrongParams"/>
<fmt:message bundle="${naming}" key="login.label.blockingAccount" var="blockingAccount"/>
<fmt:message bundle="${naming}" key="mainHeader.label.signUp" var="signUp"/>
<fmt:message bundle="${naming}" key="mainHeader.label.signIn" var="signIn"/>

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/loginStyle.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/startPage.js"></script>
    <title>${logIn}</title>
</head>

<body>
<jsp:include page="../fragments/header/mainHeader.jsp"/>
<div class="startPageContainer">
    <div class="infoLabel">
        <input class="chosenForm" checked id="signin" name="action" type="radio" value="signin"
               onclick="changeForm('signInForm')">
        <label class="info" for="signin">${signIn}</label>
        <input class="chosenForm" id="signup" name="action" type="radio" value="signup"
               onclick="changeForm('signUpForm')">
        <label class="info" for="signup">${signUp}</label>
    </div>
    <div class="formType" id="signInForm" style="display: block;">
        <form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
            <div class="loginForm">
                <div class="inputText">
                    <input class="signInForm" type="text" id="username" name="username" placeholder="${placeLogin}"
                           pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required>
                </div>

                <div class="inputText">
                    <input class="signInForm" type="password" id="password" name="password" placeholder="${placePassword}"
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
                <input id="signInButton" class="submitBtn" type="submit" value=${logIn}>
            </div>
        </form>
    </div>

    <div class="formType" id="signUpForm" style="display: none;">
        <form>
            <div class="inputText">
                <input class="signUpForm" type="text" id="lastName" placeholder="${lastName}" required>
            </div>
            <div class="inputText">
                <input class="signUpForm" type="text" id="firstName" placeholder="${firstName}" required>
            </div>
            <div class="inputText">
                <input class="signUpForm" type="text" id="email" placeholder="${email}" required>
            </div>
            <div class="inputText">
                <input class="signUpForm" type="text" id="birthday" placeholder="${birthday}"
                       onfocus="(this.type='date')" onblur="(this.type='text')" required>
            </div>
            <div class="inputText">
                <input class="signUpForm" type="text" id="login" placeholder="${placeLogin}"
                       pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required>
            </div>
            <div class="inputText">
                <input class="signUpForm" type="password" id="userPass" placeholder="${placePassword}"
                       required>
            </div>

            <div class="submitButton">
                <input class="submitBtn" id="signUpButton" type="submit" value=${signUp}>
            </div>
        </form>
    </div>
</div>

</body>
</html>
