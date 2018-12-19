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
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>
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
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${roomId}</th>
                    <th>${type}</th>
                    <th>${isBusy}</th>
                    <th></th>
                    <th></th>
                </tr>
                <jsp:useBean id="roomList" scope="request" type="java.util.List"/>
                <c:forEach items="${roomList}" var="room">
                    <tr>
                        <td>
                            <div class="data">
                                    ${room.id}
                            </div>
                        </td>
                        <td width="70"
                            name="nameRoom">${room.roomNumber}
                        </td>
                        <td name="nameRoomType">
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
                            <div class="data">
                                <c:choose>
                                    <c:when test="${room.busy == 'true'}">
                                        ${busy}
                                    </c:when>
                                    <c:when test="${room.busy == 'false'}">
                                        ${free}
                                    </c:when>
                                </c:choose>
                            </div>
                        </td>
                        <td width="50" onclick=edit()>
                            <button id="${room.id}" name="btnRoom" value="${room.id}"
                                    data-roomnumber="${room.roomNumber}"
                                    data-roomtype="${room.roomType}"
                                    class="editButton" onclick=edit(this)>${edit}
                            </button>
                        </td>
                        <td width="50">
                            <button class="deleteButton">${delete}
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <div class="addPanel">
        <button class="addButton"
                onclick="document.getElementById('addRoom').style.display='block'">${add}
        </button>
    </div>
</div>
<jsp:include page="../../fragments/room/addRoom.jsp"/>
<jsp:include page="../../fragments/room/editRoom.jsp"/>
</body>
</html>
