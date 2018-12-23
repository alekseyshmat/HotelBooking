<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="admin.title" var="users"/>
<fmt:message bundle="${naming}" key="admin.label.orders" var="orders"/>
<fmt:message bundle="${naming}" key="admin.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="admin.label.users" var="users"/>
<fmt:message bundle="${naming}" key="admin.label.roomsPrices" var="roomPrices"/>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/adminStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="buttons">
    <a href="controller?command=showAllOrders">${orders}</a>
</div>
<div class="buttons">
    <a href="controller?command=showRooms&pageNumber=1">${rooms}</a>
</div>
<div class="buttons">
    <a href="controller?command=showUsers">${users}</a>
</div>
<div class="buttons">
    <a href="controller?command=showRoomPrices">${roomPrices}</a>
</div>

</body>
</html>

