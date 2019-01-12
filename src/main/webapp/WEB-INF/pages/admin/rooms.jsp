<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomId"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>
<fmt:message bundle="${naming}" key="table.label.isBusy" var="isBusy"/>
<fmt:message bundle="${naming}" key="button.label.edit" var="edit"/>
<fmt:message bundle="${naming}" key="button.label.delete" var="delete"/>
<fmt:message bundle="${naming}" key="button.label.addRoom" var="addRoom"/>
<fmt:message bundle="${naming}" key="button.label.showPrice" var="showPrice"/>
<fmt:message bundle="${naming}" key="room.label.apartment" var="apartment"/>
<fmt:message bundle="${naming}" key="room.label.business" var="business"/>
<fmt:message bundle="${naming}" key="room.label.deluxe" var="deluxe"/>
<fmt:message bundle="${naming}" key="room.label.duplex" var="duplex"/>
<fmt:message bundle="${naming}" key="room.label.familyRoom" var="familyRoom"/>
<fmt:message bundle="${naming}" key="room.label.standard" var="standard"/>
<fmt:message bundle="${naming}" key="room.label.president" var="president"/>
<fmt:message bundle="${naming}" key="room.label.busy" var="busy"/>
<fmt:message bundle="${naming}" key="room.label.free" var="free"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <script src="${pageContext.request.contextPath}/js/editRoom.js"></script>
    <title>${rooms}</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/adminHeader.jsp"/>
    </div>
    <div class="rightColumn">
        <div class="itemLimit">
            <a class=" "
               href="${pageContext.servletContext.contextPath}/controller?command=showRooms&pageNumber=1&limit=15"
               formmethod="post" onclick=changeStatus(event)>15
            </a>
            <a class=" "
               href="${pageContext.servletContext.contextPath}/controller?command=showRooms&pageNumber=1&limit=10"
               formmethod="post" onclick=changeStatus(event)>10
            </a>
            <a class=" "
               href="${pageContext.servletContext.contextPath}/controller?command=showRooms&pageNumber=1&limit=5"
               formmethod="post" onclick=changeStatus(event)>5
            </a>
        </div>

        <div class="card">
            <table width="100%">
                <tr>
                    <th width="75">${id}</th>
                    <th>${roomId}</th>
                    <th>${type}</th>
                    <th>${cost}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="roomList" scope="request" type="java.util.List"/>
                <c:forEach items="${roomList}" var="room">
                    <tr>
                        <td>
                            <div class="data">
                                #${room.id}
                            </div>
                        </td>
                        <td>
                                ${room.roomNumber}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${room.roomType == 'APARTMENT'}">
                                    ${apartment}
                                </c:when>
                                <c:when test="${room.roomType == 'BUSINESS'}">
                                    ${business}
                                </c:when>
                                <c:when test="${room.roomType == 'DELUXE'}">
                                    ${deluxe}
                                </c:when>
                                <c:when test="${room.roomType == 'DUPLEX'}">
                                    ${duplex}
                                </c:when>
                                <c:when test="${room.roomType == 'FAMILYROOM'}">
                                    ${familyRoom}
                                </c:when>
                                <c:when test="${room.roomType == 'STANDARD'}">
                                    ${standard}
                                </c:when>
                                <c:when test="${room.roomType == 'PRESIDENT'}">
                                    ${president}
                                </c:when>
                            </c:choose>
                        </td>
                        <td>
                            <div class="showPriceButton">
                                <a href="${pageContext.servletContext.contextPath}/controller?command=showRoomPrices&roomId=${room.id}&roomLimit=${requestScope.limit}&roomPage=${requestScope.pageNumber}"
                                   class="showRoomPrice">
                                    <img class="tableImg" src="img/icon/price.png" alt="${showPrice}"
                                         title="${showPrice}">
                                </a>
                            </div>
                        </td>
                        <td>
                            <button id="${room.id}" name="btnRoom" value="${room.id}"
                                    data-roomnumber="${room.roomNumber}"
                                    data-roomtype="${room.roomType}"
                                    class="editButton" onclick=edit(this)>
                                <img class="tableImg" src="img/icon/edit.png" alt="${edit}" title="${edit}">
                            </button>

                            <button class="deleteButton">
                                <img class="tableImg" src="img/icon/delete.png" alt="${delete}" title="${delete}">
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="pages">
            <jsp:useBean id="pages" scope="request" type="java.util.List"/>
            <c:forEach items="${pages}" var="pages">
                <a href="${pageContext.servletContext.contextPath}/controller?command=showRooms&pageNumber=${pages}&limit=${limit}">${pages}</a>
            </c:forEach>
        </div>
        <div class="addPanel">
            <button class="addButton"
                    onclick="document.getElementById('addRoom').style.display='block'">${addRoom}
            </button>
        </div>
    </div>
</div>
<jsp:include page="../../fragments/room/addRoom.jsp"/>
<jsp:include page="../../fragments/room/editRoom.jsp"/>
</body>
</html>
