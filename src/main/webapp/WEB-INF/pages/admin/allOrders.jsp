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
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.orderStatus" var="orderStatus"/>
<fmt:message bundle="${naming}" key="button.label.active" var="active"/>
<fmt:message bundle="${naming}" key="button.label.processed" var="processed"/>
<fmt:message bundle="${naming}" key="button.label.completed" var="completed"/>
<fmt:message bundle="${naming}" key="button.label.complete" var="complete"/>
<fmt:message bundle="${naming}" key="button.label.showDetails" var="showDetails"/>
<fmt:message bundle="${naming}" key="table.label.paymentStatus" var="paymentStatus"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="table.label.typeRoom" var="typeRoom"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tabStyle.css">
    <script src="${pageContext.request.contextPath}/js/tab.js"></script>
    <title>All orders</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="tab">
        <button class="tabLinks active" onclick="openCity(event, 'processed')">${processed}</button>
        <button class="tabLinks " onclick="openCity(event, 'active')">${active}</button>
        <button class="tabLinks" onclick="openCity(event, 'completed')">${completed}</button>
    </div>

    <div class="leftColumn">
        <jsp:include page="../../fragments/header/adminHeader.jsp"/>
    </div>
    <div id="processed" class="rightColumn" style="display: block;">
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${name}</th>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${placeNumber}</th>
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
                                    ${order.lastName} ${order.firstName}
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
                                    ${order.placeNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.type}
                            </div>
                        </td>
                        <td>
                            <button class="processButton"
                                    onclick="document.getElementById('processOrder').style.display='block'">Process
                            </button>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="active" class="rightColumn" style="display: none;">
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${name}</th>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
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
                                    ${order.lastName} ${order.firstName}
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
                                    ${order.paymentStatus}
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
                                    <button class="completeButton"
                                            onclick="document.getElementById('processOrder').style.display='block'">${complete}
                                    </button>
                                </c:when>
                                <c:when test="${order.paymentStatus == 'PAID'}">
                                    <button class="completeButton">${complete}
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
        <div class="card">
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
                                    ${order.lastName} ${order.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.invoiceDate}
                            </div>
                        </td>
                        <td>
                            <button class="showDetailsButton"
                                    onclick="document.getElementById('showDetails').style.display='block'">${showDetails}
                            </button>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
<jsp:include page="../../fragments/order/processOrder.jsp"/>
<jsp:include page="../../fragments/order/showDetails.jsp"/>
</body>
</html>
