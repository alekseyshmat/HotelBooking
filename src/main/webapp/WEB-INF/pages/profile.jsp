<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/profileStyle.css">
</head>

<body>
<jsp:include page="../fragments/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <c:choose>
            <c:when test="${sessionScope.role == 'ADMIN'}">
                <jsp:include page="../fragments/adminHeader.jsp"/>
            </c:when>
            <c:when test="${sessionScope.role == 'USER'}">
                <jsp:include page="../fragments/userHeader.jsp"/>
            </c:when>
        </c:choose>
    </div>
    <div class="rightColumn">
        <form action="#" method="post">

            <div class="row">
                <div class="label">
                    <label>{lastName}:</label>
                </div>
                <div class="value">
                    <input type="text" id="firstName" name="firstName" value="{user.firstName}">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label>{firstName}:</label>
                </div>
                <div class="value">
                    <input type="text" id="lastName" name="lastName" value="{user.lastName}">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label>{birthday}:</label>
                </div>
                <div class="value">
                    <input type="text" id="birthday" name="birthday" value="{user.birthday}">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label>{email}:</label>
                </div>
                <div class="value">
                    <input type="text" id="email" name="email" value="{user.email}" readonly>
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label>{username}:</label>
                </div>
                <div class="value">
                    <input type="text" id="username" name="username" value="{user.username}" readonly>
                </div>
            </div>

            <div class="submitButton">
                <input class="submitBtn" type="submit" value="{save}">
            </div>

        </form>
    </div>
</div>
<%--//todo добавить личный кабинет , отображение информации--%>

</body>
</html>
