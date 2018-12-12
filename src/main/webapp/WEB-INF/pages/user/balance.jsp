<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="user.label.balance" var="balance"/>
<fmt:message bundle="${naming}" key="table.label.operation" var="operation"/>
<fmt:message bundle="${naming}" key="table.label.dateOperation" var="dateOperation"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="table.label.add" var="add"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/balanceStyle.css">
    <title>${balance}</title>
</head>
<body>
<jsp:include page="../../fragments/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/userHeader.jsp"/>
    </div>
    <div class="rightColumn">
        <div class="balanceBar">

            <div class="balanceStatus">
                ${balance}: {user.balance}
            </div>
            <div class="balanceButton">
                <a class="addBalance" href=#>${add}</a>
            </div>

        </div>
        <div class="card">
            <table>
                <tr>
                    <th>${operation}</th>
                    <th>${dateOperation}</th>
                    <th>${sum}</th>
                </tr>
                <%--<c:forEach items="${userList}" var="user">--%>
                <tr>
                    <td>
                        <div class="data">
                            {balance.operation}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {balance.date}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {balance.sum}
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
