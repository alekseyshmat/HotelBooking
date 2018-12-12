<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="table.label.add" var="add"/>
<fmt:message bundle="${naming}" key="table.label.endDate" var="endDate"/>
<fmt:message bundle="${naming}" key="table.label.startDate" var="startDate"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/addRoomPrice.js"></script>
</head>
<body>
<div id="addRoomPrice" class="modal">
    <form class="modal-content animate" action="${pageContext.servletContext.contextPath}/controller?command=addRoomPrice"
          method="post">
        <div class="modalContainer">
            <label for="roomNumber"><b>${roomNumber}</b></label>
            <select id="roomNumber" name="roomNumber">
                <jsp:useBean id="roomList" scope="request" type="java.util.List"/>
                <c:forEach items="${roomList}" var="room">
                    <option value="${room.id}">${room.roomNumber}</option>
                </c:forEach>
            </select>
            <label for="startDate">${startDate}</label>
            <input id="startDate" type="date" name="startDate">

            <label for="endDate">${endDate}</label>
            <input id="endDate" type="date" name="endDate">
            <label for="cost">${endDate}</label>
            <input id="cost" type="text" name="cost" placeholder="{enter cost}" required>

            <div>
                <input class="prcButton" type="submit" value="${add}"/>
                <button class="cancelButton" onclick="document.getElementById('addRoomPrice').style.display='none'">Cancel
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>