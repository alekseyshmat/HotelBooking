<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.firstName" var="firstName"/>
<fmt:message bundle="${naming}" key="table.label.lastName" var="lastName"/>
<fmt:message bundle="${naming}" key="table.label.birthday" var="birthday"/>
<fmt:message bundle="${naming}" key="table.label.email" var="email"/>
<fmt:message bundle="${naming}" key="user.label.login.save" var="save"/>
<fmt:message bundle="${naming}" key="user.label.login.placeholder" var="username"/>
<fmt:message bundle="${naming}" key="mainHeader.label.profile" var="profile"/>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${profile}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/profileStyle.css">
    <jsp:useBean id="user" scope="request" type="entity.User"/>
</head>

<body>
<jsp:include page="../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <c:choose>
            <c:when test="${sessionScope.role == 'ADMIN'}">
                <jsp:include page="../fragments/header/adminHeader.jsp"/>
            </c:when>
            <c:when test="${sessionScope.role == 'USER'}">
                <jsp:include page="../fragments/header/userHeader.jsp"/>
            </c:when>
        </c:choose>
    </div>
    <div class="rightColumn">
        <div class="card">
            <form action="controller?command=editProfile" method="post">
                <div class="row">
                    <div class="label">
                        <label for="lastName">${lastName}:</label>
                    </div>
                    <div class="value">
                        <input type="text" id="lastName" name="lastName" value="${user.lastName}">
                    </div>
                </div>

                <div class="row">
                    <div class="label">
                        <label for="firstName">${firstName}:</label>
                    </div>
                    <div class="value">
                        <input type="text" id="firstName" name="firstName" value="${user.firstName}">
                    </div>
                </div>

                <div class="row">
                    <div class="label">
                        <label for="birthday">${birthday}:</label>
                    </div>
                    <div class="value">
                        <input type="text" id="birthday" name="birthday" value="${user.birthday}" readonly>
                    </div>
                </div>

                <div class="row">
                    <div class="label">
                        <label for="email">${email}:</label>
                    </div>
                    <div class="value">
                        <input type="text" id="email" name="email" value="${user.email}" readonly>
                    </div>
                </div>

                <div class="row">
                    <div class="label">
                        <label for="username">${username}:</label>
                    </div>
                    <div class="value">
                        <input type="text" id="username" name="username" value="${user.login}" readonly>
                    </div>
                </div>

                <div class="submitButton">
                    <input class="submitBtn" type="submit" value="${save}">
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>
