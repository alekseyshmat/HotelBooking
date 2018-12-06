<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%--<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="names" var="names"/>

<fmt:message bundle="${names}" key="mainHeader.label.signOut" var="signOut"/>
<fmt:message bundle="${names}" key="mainHeader.label.profile" var="profile"/>
<fmt:message bundle="${names}" key="mainHeader.label.home" var="home"/>
<fmt:message bundle="${names}" key="mainHeader.label.lang" var="lang"/>
--%>

<!DOCTYPE html>
<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/mainHeaderStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="navigationBar">
    <div class="home">
        <a href="#">{home}</a> <%--TODO add link--%>
    </div>
    <div class="dropDown">
        <button class="dropButton">${sessionScope.name}
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropDownContent">
            <a href="${pageContext.servletContext.contextPath}/controller?command=showProfile">{profile}</a>
            <a href="${pageContext.servletContext.contextPath}/controller?command=signOut">{signOut}</a>
        </div>
    </div>
    <div class="dropDown">
        <button class="dropButton">{lang}
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropDownContent">
            <a href="#">Русский</a>
            <a href="#">English</a>
        </div>
    </div>
    <c:choose>
        <c:when test="${sessionScope.role == 'ADMIN'}">
            <div class="optionalButton">
                <a href="${pageContext.servletContext.contextPath}/controller?command=showOrders">{administration}</a>
            </div>
        </c:when>
        <c:when test="${sessionScope.role == 'USER'}">
            <div class="optionalButton">
                <a href="${pageContext.servletContext.contextPath}/controller?command=login">{makeOrder}</a> <%--TODO change--%>
            </div>
        </c:when>
    </c:choose>


</div>
</body>
</html>
