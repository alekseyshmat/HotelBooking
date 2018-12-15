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
    <script src="${pageContext.request.contextPath}/js/ids.js"></script>
</head>
<body>

<div id="editRoom" class="modal">


    <div class="modal-content animate">
        <form action="${pageContext.servletContext.contextPath}/controller?command=updateRoom"
              method="post">
            <label for="valueId"><b>${roomId}</b></label>
            <input type="text" id="valueId" value="">

            <label for="typeRoom"><b>${type}</b></label>
            <select id="typeRoom" name="typeRoom" value="">
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
            </div>
        </form>
        <button class="cancelButton" onclick="document.getElementById('editRoom').style.display='none'">Cancel
        </button>
    </div>
</div>

</div>
</body>
