<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>
<fmt:message bundle="${naming}" key="table.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="table.label.room" var="room"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomId"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="table.label.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.type" var="type"/>
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>
<fmt:message bundle="${naming}" key="button.label.process" var="process"/>
<fmt:message bundle="${naming}" key="table.label.name" var="name"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>
<fmt:message bundle="${naming}" key="table.label.paymentStatus" var="paymentStatus"/>
<fmt:message bundle="${naming}" key="button.label.complete" var="complete"/>
<fmt:message bundle="${naming}" key="button.label.cancel" var="cancel"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/completeOrder.js"></script>
</head>
<body>
<div id="completeOrder" class="modal">

    <div class="modal-content animate">
        <form action="${pageContext.request.contextPath}/controller?command=completeOrder" method="post">
            <%--<jsp:useBean id="currentOrder" scope="request" type="java.util.List"/>--%>
            <%--<c:forEach items="${currentOrder}" var="order">--%>
               <%--<label hidden name="id">${order.id}</label>--%>
               <label hidden name="id">2</label>
                <label for="name"><b>${name}</b></label>
                <input type="text" id="name" name="uname" value="${order.firstName} ${order.lastName}"
                       readonly>
                <label><b>${checkInDate}</b></label>
                <input type="text" name="checkInDate" value="${order.checkInDate}"
                       readonly>

                <label><b>${checkOutDate}</b></label>
                <input type="text" name="checkOutDate" value="${order.checkOutDate}" readonly>

                <label for="roomNumber"><b>${roomNumber}</b></label>
                <input id="roomNumber" type="text" name="roomNumber" value="${order.roomNumber}" readonly>

                <label for="cost"><b>${cost}</b></label>
                <input id="cost" type="text" name="cost" value="${order.cost}" readonly>

                <label for="paymentStatus"><b>${paymentStatus}</b></label>
                <input id="paymentStatus" type="text" name="paymentStatus" value="${order.paymentStatus}" readonly>
            <%--</c:forEach>--%>
                <button class="prcButton" type="submit">${complete}</button>
        </form>

        <div>
            <button class="cancelButton" type="submit"
                    onclick="document.getElementById('completeOrder').style.display='none'">${cancel}
            </button>
        </div>
    </div>

</div>
</body>
</html>
