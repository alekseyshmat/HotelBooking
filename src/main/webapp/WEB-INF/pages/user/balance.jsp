<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <title>Balance</title>
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
                {balance}: {user.balance}
            </div>
            <div class="balanceButton">
                <a class="addBalance" href=#>{add}</a>
            </div>

        </div>


        <div class="card">
            <table>
                <tr>
                    <th>{Operation}</th>
                    <th>{DateOperation}</th>
                    <th>{Sum}</th>
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
