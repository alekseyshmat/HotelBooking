<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomId"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>
<fmt:message bundle="${naming}" key="button.label.edit" var="edit"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/edit.js"></script>
</head>
<body>

<div id="editRoom" class="modal">
    <script>
        var input = document.getElementById('valueId');
        var roomIds = document.getElementById('idRoom');

        input.value = roomIds;
    </script>
    <form class="modal-content animate" action="${pageContext.servletContext.contextPath}/controller?command=updateRoom"
          method="post">
        <div class="modalContainer">
            <label for="valueId"><b>${roomId}</b></label>
            <input type="text" id="valueId" value="">

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
                <input class="prcButton" type="submit" value="${edit}"/>
                <button class="cancelButton" onclick="document.getElementById('editRoom').style.display='none'">Cancel
                </button>
                <%--TODO: add --%>
            </div>
        </div>
    </form>
</div>
</body>
