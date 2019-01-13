<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="user.label.balance" var="balance"/>
<fmt:message bundle="${naming}" key="user.label.enterSum" var="enterSum"/>
<fmt:message bundle="${naming}" key="table.label.operation" var="operation"/>
<fmt:message bundle="${naming}" key="table.label.dateOperation" var="dateOperation"/>
<fmt:message bundle="${naming}" key="table.label.sum" var="sum"/>
<fmt:message bundle="${naming}" key="button.label.add" var="add"/>
<fmt:message bundle="${naming}" key="button.label.showHistory" var="showHistory"/>
<fmt:message bundle="${naming}" key="button.label.topUp" var="topUp"/>
<fmt:message bundle="${naming}" key="table.label.moneyTransfer" var="moneytransfer"/>
<fmt:message bundle="${naming}" key="table.label.paymentForServices" var="paymentForServices"/>
<fmt:message bundle="${naming}" key="profile.label.refileBalance" var="refileBalance"/>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/balanceStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tabStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">

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
                ${balance}: ${user.balance}$
            </div>

            <form action="${pageContext.request.contextPath}/controller?command=refileBalance" method="post">
                <div class="inputBalance">
                    <input type="text" id="sumUp" name="sumUp" placeholder="${enterSum}">
                </div>
                <div class="balanceButton">
                    <button class="addBalance" type="submit">${topUp}</button>
                </div>
            </form>
        </div>
        <c:if test="${not empty requestScope.message}">
            <div class="modal" id="refileBalanceNotify" style="display: block;">
                <div class="modal-content animate">
                       <span class="resultButtons">
                        <label>${refileBalance}</label>
                <a class="noButton" type="submit"
                   href="${pageContext.servletContext.contextPath}/controller?command=showBalance">Ok
                </a>
                       </span>
                </div>
            </div>
        </c:if>
    </div>
    <div id="showHistory" class="rightColumn" style="display: none;">
        <div class="tableScroll">
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
                                <c:choose>
                                    <c:when test="${transaction.operationType == 'MONEYTRANSFER'}">
                                        ${moneytransfer}
                                    </c:when>
                                    <c:when test="${transaction.operationType== 'PAYMENTFORSERVICES'}">
                                        ${paymentForServices}
                                    </c:when>
                                </c:choose>
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
<jsp:include page="/WEB-INF/fragments/header/footer.jsp"/>
</body>
</html>
