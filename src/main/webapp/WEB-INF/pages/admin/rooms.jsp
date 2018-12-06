<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <title>{Rooms}</title>
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
                    <th>{type}</th>
                    <th>{placeNumber}</th>
                    <th>{cost}</th>
                    <th>{isBust}</th>
                </tr>
                <%--<c:forEach items="${userList}" var="user">--%>
                <tr>
                    <td>
                        <div class="data">
                            {room.id}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {room.roomNumber}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {room.type}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {room.placeNumber}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {room.cost}
                        </div>
                    </td>
                    <td>
                        <div class="data">
                            {room.isBusy}
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
