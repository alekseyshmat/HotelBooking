<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="text" var="text"/>

<fmt:message bundle="${text}" key="admin.title" var="users"/>
<fmt:message bundle="${text}" key="admin.label.orders" var="orders"/>
<fmt:message bundle="${text}" key="admin.label.rooms" var="rooms"/>
<fmt:message bundle="${text}" key="admin.label.users" var="users"/>
<fmt:message bundle="${text}" key="admin.label.roomsPrices" var="roomPrices"/>
--%>


<html>
<head>
    <meta charset="UTF-8">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/style/adminStyle.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <title>{users}</title>
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
                    <th>{id}</th>
                    <th>{lastName}</th>
                    <th>{firstName}</th>
                    <th>{birthday}</th>
                    <th>{email}</th>
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
                                    {user.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    {user.lastName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    {user.userName}
                            </div>
                        </td>
                        <td>
                            <div class="data">
                                    {user.email}
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
