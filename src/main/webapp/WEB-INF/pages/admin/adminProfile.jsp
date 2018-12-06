<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/adminStyle.css">
    <title> admin page</title>

</head>

<body>
<jsp:include page="../../fragments/mainHeader.jsp"/>

<div class="container">


    <div class="rightColumn">
        <div class="card">
            <hr>
            <c:forEach items="${userList}" var="user">
                <div class="data">
                        ${user.id}${user.firstName}${user.lastName} ${user.login} ${user.email}
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
