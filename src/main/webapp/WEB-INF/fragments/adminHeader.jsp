<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%--
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="names" var="names"/>

<fmt:message bundle="${names}" key="admin.title" var="users"/>
<fmt:message bundle="${names}" key="admin.label.orders" var="orders"/>
<fmt:message bundle="${names}" key="admin.label.rooms" var="rooms"/>
<fmt:message bundle="${names}" key="admin.label.users" var="users"/>
<fmt:message bundle="${names}" key="admin.label.roomsPrices" var="roomPrices"/>

--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/adminStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h1>Hotel Booking</h1>

<div class="buttons">
    <a href="controller?command=showOrders">{orders}</a>
</div>
<div class="buttons">
    <a href="controller?command=showRooms">{rooms}</a>
</div>
<div class="buttons">
    <a href="controller?command=showUsers">{users}</a>
</div>
<div class="buttons">
    <a href="controller?command=showRoomPrices">{roomPrices}</a>
</div>

</body>
</html>

