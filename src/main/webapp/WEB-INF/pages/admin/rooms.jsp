<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>
<fmt:message bundle="${naming}" key="table.label.isBusy" var="isBusy"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
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
                    <th>${roomNumber}</th>
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
                        <td width="70" id="roomNumber">
                            <div class="data">
                                    ${room.roomNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${room.roomType}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${room.busy}
                            </div>
                        </td>
                        <td width="50">
                            <button class="editButton"
                                    onclick="document.getElementById('editRoom').style.display='block'">Edit
                            </button>
                        </td>
                        <td width="50">
                            <button class="deleteButton">Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <div class="addPanel">
        <button class="addButton"
                onclick="document.getElementById('addRoom').style.display='block'">Add
        </button>
    </div>
</div>
<jsp:include page="../../fragments/room/addRoom.jsp"/>
<jsp:include page="../../fragments/room/editRoom.jsp"/>
</body>
</html>
