<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="mainHeader.label.makeOrder" var="makeOrder"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="user.label.login.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.orderStatus" var="orderStatus"/>
<fmt:message bundle="${naming}" key="table.label.paymentStatus" var="paymentStatus"/>
<fmt:message bundle="${naming}" key="button.label.active" var="active"/>
<fmt:message bundle="${naming}" key="button.label.processed" var="processed"/>
<fmt:message bundle="${naming}" key="button.label.pay" var="pay"/>
<fmt:message bundle="${naming}" key="button.label.cancel" var="cancel"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>


<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tabStyle.css">
    <script src="${pageContext.request.contextPath}/js/tab.js"></script>
    <title>My orders</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="tab">
        <button class="tabLinks active" onclick="openCity(event, 'active')">${active}</button>
        <button class="tabLinks" onclick="openCity(event, 'processed')">${processed}</button>
    </div>
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/userHeader.jsp"/>
    </div>

    <div id="active" class="rightColumn" style="display: block;">
        <div class="card">
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
                                    ${activeOrder.roomNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${activeOrder.paymentStatus}
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
                                    <button class="paymentButton"
                                            onclick="document.getElementById('processOrder').style.display='block'">${pay}
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
        <div class="card">
            <table>
                <tr>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${typeRoom}</th>
                    <th>${placeNumber}</th>
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
                                    ${order.type}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.placeNumber}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${order.paymentStatus}
                            </div>
                        </td>
                        <td>
                            <button class="deleteButton"
                                    onclick="document.getElementById('processOrder').style.display='block'">${cancel}
                            </button>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
<%--TODO ДОБАВИТЬ КНОПКУ ОТМЕНИТЬ ЗАКАЗ--%>
</body>
</html>
