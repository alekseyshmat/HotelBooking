<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.firstName" var="firstName"/>
<fmt:message bundle="${naming}" key="table.label.lastName" var="lastName"/>
<fmt:message bundle="${naming}" key="admin.title" var="users"/>
<fmt:message bundle="${naming}" key="admin.label.orders" var="orders"/>
<fmt:message bundle="${naming}" key="admin.label.rooms" var="rooms"/>
<fmt:message bundle="${naming}" key="admin.label.users" var="users"/>
<fmt:message bundle="${naming}" key="admin.label.roomsPrices" var="roomPrices"/>
<fmt:message bundle="${naming}" key="table.label.birthday" var="birthday"/>
<fmt:message bundle="${naming}" key="table.label.email" var="email"/>
<fmt:message bundle="${naming}" key="table.label.block" var="block"/>
<fmt:message bundle="${naming}" key="table.label.unblock" var="unblock"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <title>${users}</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>

<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/adminHeader.jsp"/>
    </div>
    <div class="rightColumn">
        <div class="card">
            <table>
                <tr>
                    <th>${id}</th>
                    <th>${lastName}</th>
                    <th>${firstName}</th>
                    <th>${birthday}</th>
                    <th>${email}</th>
                    <th></th>
                </tr>
                <jsp:useBean id="userList" scope="request" type="java.util.List"/>

                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>
                                ${user.id}
                        </td>
                        <td>
                            <div class="data">
                                    ${user.lastName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${user.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${user.birthday}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    ${user.email}
                            </div>
                        </td>
                        <td width=20%>
                            <div class="blockedBtn">
                                <c:choose>
                                    <c:when test="${user.blockingStatus == 'UNBLOCKED'}">
                                        <a class="block"
                                           href="${pageContext.servletContext.contextPath}/controller?command=changeBlockingStatus&idClient=${user.id}&blockingStatus=blocked">
                                            ${block} </a>
                                    </c:when>
                                    <c:when test="${user.blockingStatus == 'BLOCKED'}">
                                        <a class="unblock"
                                           href="${pageContext.servletContext.contextPath}/controller?command=changeBlockingStatus&idClient=${user.id}&blockingStatus=unblocked">
                                            ${unblock} </a>
                                    </c:when>
                                </c:choose>
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
