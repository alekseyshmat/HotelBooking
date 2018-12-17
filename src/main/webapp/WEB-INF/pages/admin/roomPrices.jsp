<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomId"/>
<fmt:message bundle="${naming}" key="table.label.startDate" var="startDate"/>
<fmt:message bundle="${naming}" key="table.label.endDate" var="endDate"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <title>Room prices</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/adminHeader.jsp"/>
    </div>
    <div class="rightColumn">
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${roomId}</th>
                    <th>${startDate}</th>
                    <th>${endDate}</th>
                    <th>${cost}</th>
                </tr>
                <jsp:useBean id="roomPriceList" scope="request" type="java.util.List"/>
                <c:forEach items="${roomPriceList}" var="roomPrice">
                    <tr>
                        <td>
                            <div class="data">
                                    ${roomPrice.id}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${roomPrice.roomNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${roomPrice.startDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${roomPrice.endDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${roomPrice.cost}
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="addPanel">
        <button class="addButton"
                onclick="document.getElementById('addRoomPrice').style.display='block'">${add}
        </button>
    </div>
</div>
<jsp:include page="../../fragments/room/addRoomPrice.jsp"/>
</body>
</html>
