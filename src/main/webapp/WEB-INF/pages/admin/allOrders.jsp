<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.firstName" var="firstName"/>
<fmt:message bundle="${naming}" key="table.label.lastName" var="lastName"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.orderStatus" var="orderStatus"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <title>All orders</title>
</head>
<body>
<jsp:include page="../../fragments/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/adminHeader.jsp"/>
    </div>
    <div class="rightColumn">
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${lastName} ${firstName}</th>
                    <th>${checkInDate}</th>
                    <th>${checkOutDate}</th>
                    <th>${placeNumber}</th>
                    <th>${orderStatus}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="orderList" scope="request" type="java.util.List"/>
                <c:forEach items="${orderList}" var="order">
                    <tr>
                        <td>
                            <div class="data">
                                add <%--${user.id}--%>
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                add<%--${user.firstName} ${user.lastName}--%>
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
                                    ${order.orderStatus}
                            </div>
                        </td>
                        <td>
                            <div>
                                <button class="processButton"
                                        onclick="document.getElementById('id01').style.display='block'">Process
                                </button>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../../fragments/modalProcessOrder.jsp"/>
</body>
</html>
