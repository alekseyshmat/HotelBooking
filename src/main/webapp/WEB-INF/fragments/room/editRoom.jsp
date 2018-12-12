<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="table.label.add" var="add"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/edit.js"></script>
</head>
<body>
<script>
    var nameRoom = document.getElementById("roomNumber");
</script>

<div id="editRoom" class="modal">
    <form class="modal-content animate" action="${pageContext.servletContext.contextPath}/controller?command=updateRoom"
          method="post">
        <div class="modalContainer">
            <label for="name"><b>${roomNumber}</b></label>
            <input type="text" id="name" value=required>
            <label for="typeRoom"><b>${type}</b></label>
            <select id="typeRoom" name="typeRoom">
                <option disabled>${type}</option>
                <option value="Apartment">Apartment</option>
                <option value="Business">Business</option>
                <option value="Deluxe">Deluxe</option>
                <option value="Duplex">Duplex</option>
                <option value="FamilyRoom">Family room</option>
                <option value="Standard">Standard</option>
                <option value="President">President</option>
            </select>
            <div>
                <input class="prcButton" type="submit" value="{edit}"/>
                <button class="cancelButton" onclick="document.getElementById('editRoom').style.display='none'">Cancel
                </button>
                <%--TODO: add --%>
            </div>
        </div>
    </form>
</div>
</body>
