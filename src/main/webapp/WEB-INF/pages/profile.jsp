<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/adminStyle.css">
    <title> admin page</title>

</head>

<body>
<jsp:include page="../fragments/mainHeader.jsp"/>

<ul>
    <li><a class="active" href="controller?command=showOrders">Заказы</a></li>
    <li><a href="controller?command=showRooms">Номера</a></li>
    <li><a href="controller?command=showUsers">Пользователи</a></li>
    <li><a href="controller?command=showRoomPrices">Цена номеров</a></li>
</ul>

</body>
</html>
