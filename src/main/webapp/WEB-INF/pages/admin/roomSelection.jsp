<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <title>Title</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>

<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/adminHeader.jsp"/>
    </div>
    <form action="${pageContext.request.contextPath}/controller?command=processOrder" method="post">
        <div class="rightColumn">
            <div class="card">
                <table>
                    <tr>
                        <th></th>
                        <th>${roomNumber}</th>
                        <th>${type}</th>
                        <th>${cost}</th>
                    </tr>
                    <jsp:useBean id="roomsWithCriteria" scope="request" type="java.util.List"/>
                    <c:forEach items="${roomsWithCriteria}" var="foundRooms">
                        <tr>
                            <td>
                                <input type="radio" id="idRoom" name="idRoom" value="${foundRooms.id}">
                            </td>
                            <td>
                                <div class="data">
                                        ${foundRooms.room.roomNumber}
                                </div>
                            </td>
                            <td>
                                <div class="data">
                                        ${foundRooms.room.roomType}
                                </div>
                            </td>
                            <td>
                                <div class="data">
                                    <input type="hidden" id="cost" name="cost" value="${foundRooms.roomPrice.cost}">
                                        ${foundRooms.roomPrice.cost}
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="addPanel">
            <button type="submit">{choose}
            </button>
        </div>
    </form>
</div>
</body>
</html>
