<%--
  Created by IntelliJ IDEA.
  User: leha2
  Date: 01.12.2018
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <th>{id}</th>
                    <th>{roomNumber}</th>
                    <th>{startDate}</th>
                    <th>{endDate}</th>
                    <th>{cost}</th>
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
