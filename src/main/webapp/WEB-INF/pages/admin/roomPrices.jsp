<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomNumber"/>
<fmt:message bundle="${naming}" key="table.label.startDate" var="startDate"/>
<fmt:message bundle="${naming}" key="table.label.endDate" var="endDate"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <title>Room prices</title>
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
                    <th>${roomNumber}</th>
                    <th>${startDate}</th>
                    <th>${endDate}</th>
                    <th>${cost}</th>
                </tr>
                <%--<c:forEach items="${userList}" var="user">--%>
                <tr>
                    <td>
                        <div class="data">
                            {roomPrice.id}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {roomPrice.roomNumber}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {roomPrice.startDate}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {roomPrice.endDate}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {roomPrice.cost}
                        </div>
                    </td>
                </tr>
                <%--</c:forEach>--%>
            </table>
        </div>
    </div>
</div>

</body>
</html>
