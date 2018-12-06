<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
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
                    <th>{id}</th>
                    <th>{lastName} {firstName}</th>
                    <th>{checkInDate}</th>
                    <th>{checkOutDate}</th>
                    <th>{placeNumber}</th>
                    <th>{orderStatus}</th>
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
                            {user.firstName} {user.lastName}
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


</body>
</html>
