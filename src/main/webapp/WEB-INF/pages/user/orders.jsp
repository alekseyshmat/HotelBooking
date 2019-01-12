<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="mainHeader.label.makeOrder" var="makeOrder"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="table.label.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.orderStatus" var="orderStatus"/>
<fmt:message bundle="${naming}" key="table.label.paymentStatus" var="paymentStatus"/>
<fmt:message bundle="${naming}" key="button.label.active" var="active"/>
<fmt:message bundle="${naming}" key="button.label.processed" var="processed"/>
<fmt:message bundle="${naming}" key="button.label.completed" var="completed"/>
<fmt:message bundle="${naming}" key="button.label.pay" var="pay"/>
<fmt:message bundle="${naming}" key="button.label.cancel" var="cancel"/>
<fmt:message bundle="${naming}" key="button.label.canceled" var="canceled"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.paid" var="paid"/>
<fmt:message bundle="${naming}" key="table.label.unpaid" var="unpaid"/>
<fmt:message bundle="${naming}" key="room.label.apartment" var="apartment"/>
<fmt:message bundle="${naming}" key="room.label.business" var="business"/>
<fmt:message bundle="${naming}" key="room.label.deluxe" var="deluxe"/>
<fmt:message bundle="${naming}" key="room.label.duplex" var="duplex"/>
<fmt:message bundle="${naming}" key="room.label.familyRoom" var="familyRoom"/>
<fmt:message bundle="${naming}" key="room.label.standard" var="standard"/>
<fmt:message bundle="${naming}" key="room.label.president" var="president"/>
<fmt:message bundle="${naming}" key="table.label.name" var="name"/>
<fmt:message bundle="${naming}" key="table.label.invoiceDate" var="invoiceDate"/>
<fmt:message bundle="${naming}" key="button.label.showDetails" var="showDetails"/>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tabStyle.css">
    <script src="${pageContext.request.contextPath}/js/tab.js"></script>
    <script src="${pageContext.request.contextPath}/js/userOrder.js"></script>
    <title>My orders</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="tab">
        <button class="tabLinks active" onclick="openCity(event, 'active')">${active}</button>
        <button class="tabLinks" onclick="openCity(event, 'processed')">${processed}</button>
        <button class="tabLinks" onclick="openCity(event, 'completed')">${completed}</button>
    </div>
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/userHeader.jsp"/>
    </div>

    <div id="active" class="rightColumn" style="display: block;">
        <div class="tableScroll">
            <table>
                <tr>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${roomNumber}</th>
                    <th>${paymentStatus}</th>
                    <th>${sum}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="activeOrderList" scope="request" type="java.util.List"/>
                <c:forEach items="${activeOrderList}" var="activeOrder">
                    <tr>
                        <td>
                            <div class="data">
                                    ${activeOrder.checkInDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${activeOrder.checkOutDate}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${activeOrder.room.roomNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                <c:choose>
                                    <c:when test="${activeOrder.paymentStatus == 'UNPAID'}">
                                        ${unpaid}
                                    </c:when>
                                    <c:when test="${activeOrder.paymentStatus == 'PAID'}">
                                        ${paid}
                                    </c:when>
                                </c:choose>
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${activeOrder.cost}
                            </div>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${activeOrder.paymentStatus == 'UNPAID'}">
                                    <button type="submit" data-orderid="${activeOrder.id}" value=""
                                            class="paymentButton"
                                            onclick="payOrder(this)">
                                            ${pay}
                                    </button>
                                </c:when>
                                <c:when test="${activeOrder.paymentStatus == 'PAID'}">
                                    <button disabled class="paymentButton">${pay}
                                    </button>
                                </c:when>
                            </c:choose>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div id="processed" class="rightColumn" style="display: none;">
        <div class="tableScroll">
            <table>
                <tr>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${typeRoom}</th>
                    <th>${paymentStatus}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="userOrderList" scope="request" type="java.util.List"/>
                <c:forEach items="${userOrderList}" var="order">
                    <tr>
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
                            <div class="data">
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
                            </div>
                        </td>
                        <td>
                            <button type="submit" class="deleteButton"
                                    data-orderid="${order.id}"
                                    value=""
                                    onclick="cancelOrder(this)">${cancel}
                            </button>
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
                            <c:choose>
                                <c:when test="${order.orderStatus == 'CANCELED'}">
                                    ${canceled}
                                </c:when>
                                <c:when test="${order.orderStatus== 'COMPLETED'}">
                                    <button data-completeid="${order.id}"
                                            data-name="${order.user.lastName} ${order.user.firstName}"
                                            data-indate="${order.checkInDate}"
                                            data-outdate="${order.checkOutDate}"
                                            data-invoicedate="${order.invoiceDate}"
                                            data-roomnumber="${order.room.roomNumber}"
                                            data-cost="${order.cost}"
                                            class="showDetailsButton"
                                            onclick=showDetailsBtn(this)>${showDetails}
                                    </button>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../../fragments/order/payOrder.jsp"/>
<jsp:include page="../../fragments/order/showDetails.jsp"/>
<jsp:include page="../../fragments/order/canceledOrder.jsp"/>
</body>
</html>
