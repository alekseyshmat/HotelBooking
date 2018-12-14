<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomId"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/processOrder.js"></script>
</head>
<body>
<div id="processOrder" class="modal">

    <div class="modal-content animate">
        <form action="#" method="post">
            <label for="name"><b>Username</b></label>
            <input type="text" id="name" name="uname" value="{Name} {Surname}"
                   readonly>
            <label><b>{CheckInDate}</b></label>
            <input type="text" name="checkInDate" value="{checkInDate}"
                   readonly>
            <label><b>{CheckOutDate}</b></label>
            <input type="text" name="{checkOutDate}" readonly>
            <label><b>{Type}</b></label>
            <input type="text" name="type" value="{type}" readonly>
            <label for="typeRoom"><b>TypeRoom</b></label>
            <input id="typeRoom" type="text" name="type" value="{type}" readonly>
            <label for="chooseTypeRoom"><b>{chooseTypeRoom}</b></label>
            <div>
                <select class="chooseTypeModal" id="chooseTypeRoom" name="typeRoom">
                    <option disabled>${type}</option>
                    <option>${type}</option>
                </select>
                <button class="prcButton" type="submit">Process</button>
            </div>
        </form>
        <div>
            <button class="cancelButton" type="submit"
                    onclick="document.getElementById('processOrder').style.display='none'">Cancel
            </button>
        </div>
    </div>

</div>
</body>
</html>
