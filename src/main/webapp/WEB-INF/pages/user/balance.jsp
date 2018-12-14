<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="user.label.balance" var="balance"/>
<fmt:message bundle="${naming}" key="table.label.operation" var="operation"/>
<fmt:message bundle="${naming}" key="table.label.dateOperation" var="dateOperation"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>
<fmt:message bundle="${naming}" key="button.label.showHistory" var="showHistory"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/balanceStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tabStyle.css">
    <script src="${pageContext.request.contextPath}/js/tab.js"></script>
    <title>${balance}</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="tab">
        <button class="tabLinks active" onclick="openCity(event, 'balance')">${balance}</button>
        <button class="tabLinks" onclick="openCity(event, 'showHistory')">${showHistory}</button>
    </div>
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/userHeader.jsp"/>
    </div>
    <div id="balance" class="rightColumn" style="display: block;">
        <div class="balanceBar">
            <jsp:useBean id="user" scope="request" type="entity.User"/>
            <div class="balanceStatus">
                ${balance}: ${user.balance}
            </div>
            <div class="balanceButton">
                <a class="addBalance" href=#>${add}</a>
            </div>
        </div>
    </div>

    <div id="showHistory" class="rightColumn" style="display: none;">
        <div class="card">
            <table>
                <tr>
                    <th>${operation}</th>
                    <th>${dateOperation}</th>
                    <th>${sum}</th>
                </tr>
                <jsp:useBean id="transactionList" scope="request" type="java.util.List"/>
                <c:forEach items="${transactionList}" var="transaction">
                    <tr>
                        <td>
                            <div class="data">
                                    ${transaction.operationType}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${transaction.date}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${transaction.sum}
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
