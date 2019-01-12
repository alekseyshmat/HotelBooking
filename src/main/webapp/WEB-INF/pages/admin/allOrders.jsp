<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.name" var="name"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="table.label.invoiceDate" var="invoiceDate"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.orderStatus" var="orderStatus"/>
<fmt:message bundle="${naming}" key="button.label.active" var="active"/>
<fmt:message bundle="${naming}" key="button.label.processed" var="processed"/>
<fmt:message bundle="${naming}" key="button.label.process" var="process"/>
<fmt:message bundle="${naming}" key="button.label.completed" var="completed"/>
<fmt:message bundle="${naming}" key="button.label.complete" var="complete"/>
<fmt:message bundle="${naming}" key="button.label.showDetails" var="showDetails"/>
<fmt:message bundle="${naming}" key="table.label.paymentStatus" var="paymentStatus"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="table.label.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.paid" var="paid"/>
<fmt:message bundle="${naming}" key="table.label.unpaid" var="unpaid"/>
<fmt:message bundle="${naming}" key="room.label.apartment" var="apartment"/>
<fmt:message bundle="${naming}" key="room.label.business" var="business"/>
<fmt:message bundle="${naming}" key="room.label.deluxe" var="deluxe"/>
<fmt:message bundle="${naming}" key="room.label.duplex" var="duplex"/>
<fmt:message bundle="${naming}" key="room.label.familyRoom" var="familyRoom"/>
<fmt:message bundle="${naming}" key="room.label.standard" var="standard"/>
<fmt:message bundle="${naming}" key="room.label.president" var="president"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tabStyle.css">
    <script src="${pageContext.request.contextPath}/js/tab.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminOrders.js"></script>

    <title>All orders</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="tab">
        <button class="tabLinks active" onclick="openCity(event, 'processed')">${processed}</button>
        <button class="tabLinks" onclick="openCity(event, 'active')">${active}</button>
        <button class="tabLinks" onclick="openCity(event, 'completed')">${completed}</button>
    </div>

    <div class="leftColumn">
        <jsp:include page="/WEB-INF/fragments/header/adminHeader.jsp"/>
    </div>

    <div id="processed" class="rightColumn" style="display: block;">
        <div class="tableScroll">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${name}</th>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${typeRoom}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="orderList" scope="request" type="java.util.List"/>
                <c:forEach items="${orderList}" var="order">
                    <tr>
                        <td>
                            <div class="data">
                                #${order.id}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.user.lastName} ${order.user.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.checkInDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.checkOutDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                <c:choose>
                                    <c:when test="${order.type == 'APARTMENT'}">
                                        ${apartment}
                                    </c:when>
                                    <c:when test="${order.type== 'BUSINESS'}">
                                        ${business}
                                    </c:when>
                                    <c:when test="${order.type== 'DELUXE'}">
                                        ${deluxe}
                                    </c:when>
                                    <c:when test="${order.type== 'DUPLEX'}">
                                        ${duplex}
                                    </c:when>
                                    <c:when test="${order.type== 'FAMILYROOM'}">
                                        ${familyRoom}
                                    </c:when>
                                    <c:when test="${order.type== 'STANDARD'}">
                                        ${standard}
                                    </c:when>
                                    <c:when test="${order.type== 'PRESIDENT'}">
                                        ${president}
                                    </c:when>
                                </c:choose>
                            </div>
                        </td>
                        <td>
                            <div class="prcBtn">
                                <a class="processButton"
                                   href="${pageContext.servletContext.contextPath}/controller?command=searchRoomByCriteria&id=${order.id}&inDate=${order.checkInDate}&outDate=${order.checkOutDate}&type=${order.type}">${process}</a>
                            </div>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
    <div id="active" class="rightColumn" style="display: none;">
        <div class="tableScroll">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${name}</th>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${roomNumber}</th>
                    <th>${paymentStatus}</th>
                    <th>${sum}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="activeOrderList" scope="request" type="java.util.List"/>
                <c:forEach items="${activeOrderList}" var="order">
                    <tr>
                        <td>
                            <div class="data">
                                #${order.id}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.user.lastName} ${order.user.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.checkInDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.checkOutDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.room.roomNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                <c:choose>
                                    <c:when test="${order.paymentStatus == 'UNPAID'}">
                                        ${unpaid}
                                    </c:when>
                                    <c:when test="${order.paymentStatus == 'PAID'}">
                                        ${paid}
                                    </c:when>
                                </c:choose>
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.cost}
                            </div>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${order.paymentStatus == 'UNPAID'}">
                                    <button class="completeButton">${complete}
                                    </button>
                                </c:when>
                                <c:when test="${order.paymentStatus == 'PAID'}">
                                    <button data-activeid="${order.id}"
                                            data-name="${order.user.lastName} ${order.user.firstName}"
                                            data-paystatus="${order.paymentStatus}"
                                            data-indate="${order.checkInDate}"
                                            data-outdate="${order.checkOutDate}"
                                            data-roomnumber="${order.room.roomNumber}"
                                            data-cost="${order.cost}"
                                            class="completeButton"
                                            onclick="completeOrderBtn(this)">${complete}
                                    </button>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="completed" class="rightColumn" style="display: none;">
        <div class="tableScroll">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${name}</th>
                    <th>${invoiceDate}</th>
                    <th></th>
                </tr>

                <jsp:useBean id="completedOrderList" scope="request" type="java.util.List"/>
                <c:forEach items="${completedOrderList}" var="order">
                    <tr>
                        <td>
                            <div class="data">
                                #${order.id}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.user.lastName} ${order.user.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.invoiceDate}
                            </div>
                        </td>
                        <td>
                            <button data-completeid="${order.id}"
                                    data-name="${order.user.lastName} ${order.user.firstName}"
                                    data-indate="${order.checkInDate}"
                                    data-outdate="${order.checkOutDate}"
                                    data-invoicedate="${order.invoiceDate}"
                                    data-roomnumber="${order.room.roomNumber}"
                                    data-cost="${order.cost}"
                                    class="showDetailsButton"
                                    onclick=showDetailsBtn(this)>
                                    ${showDetails}
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/fragments/order/processOrder.jsp"/>
<jsp:include page="/WEB-INF/fragments/order/completeOrder.jsp"/>
<jsp:include page="/WEB-INF/fragments/order/showDetails.jsp"/>
<jsp:include page="/WEB-INF/fragments/header/footer.jsp"/>
</body>
</html>
