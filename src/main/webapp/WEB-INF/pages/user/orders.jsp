<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="mainHeader.label.makeOrder" var="makeOrder"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="user.label.login.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.orderStatus" var="orderStatus"/>


<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <title>My orders</title>
</head>
<body>
<jsp:include page="../../fragments/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/userHeader.jsp"/>
    </div>
    <div class="rightColumn">
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${placeNumber}</th>
                    <th>${orderStatus}</th>
                </tr>
                <%--<c:forEach items="${userList}" var="user">--%>
                <tr>
                    <td>
                        <div class="data">
                            {user.id}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {order.checkInDate}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {order.checkOutDate}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {order.placeNumber}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {order.orderStatus}
                        </div>
                    </td>

                </tr>
                <%--</c:forEach>--%>
            </table>
        </div>
    </div>
</div>
<%--TODO ДОБАВИТЬ КНОПКУ ОТМЕНИТЬ ЗАКАЗ--%>
</body>
</html>
