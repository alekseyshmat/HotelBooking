<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="table.label.id" var="id"/>
<fmt:message bundle="${naming}" key="table.label.roomNumber" var="roomId"/>
<fmt:message bundle="${naming}" key="table.label.startDate" var="startDate"/>
<fmt:message bundle="${naming}" key="table.label.endDate" var="endDate"/>
<fmt:message bundle="${naming}" key="table.label.cost" var="cost"/>
<fmt:message bundle="${naming}" key="button.label.addRoomPrice" var="addRoomPrice"/>
<fmt:message bundle="${naming}" key="table.label.priceForRoom" var="priceForRoom"/>
<fmt:message bundle="${naming}" key="table.label.returnPage" var="returnPage"/>
<fmt:message bundle="${naming}" key="room.label.addingPrice" var="addingPrice"/>
<fmt:message bundle="${naming}" key="room.label.invalidData" var="invalidData"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/dataStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/tableStyle.css">
    <script src="${pageContext.request.contextPath}/js/addPrice.js"></script>
    <title>Room prices</title>
</head>
<body>
<jsp:include page="../../fragments/header/mainHeader.jsp"/>
<div class="container">
    <div class="leftColumn">
        <jsp:include page="../../fragments/header/adminHeader.jsp"/>
    </div>

    <div class="rightColumn">
        <div class="infoLabels">
            <div class="returnPriceLabel">
                <c:if test="${not empty requestScope.roomPage && not empty requestScope.roomLimit}">
                    <a href="${pageContext.servletContext.contextPath}/controller?command=showRooms&pageNumber=${requestScope.roomPage}&limit=${requestScope.roomLimit}"
                    >${returnPage}</a>
                </c:if>
                <div class="priceLabel">
                    <c:if test="${not empty requestScope.roomNumber}">
                        ${priceForRoom} ${requestScope.roomNumber}
                    </c:if>
                </div>
            </div>
            <div class="card">
                <table>
                    <tr>
                        <th>${id}</th>
                        <th>${startDate}</th>
                        <th>${endDate}</th>
                        <th>${cost}</th>
                    </tr>
                    <jsp:useBean id="roomPriceList" scope="request" type="java.util.List"/>
                    <c:forEach items="${roomPriceList}" var="roomPrice">
                        <tr>
                            <td>
                                <div class="data">
                                        ${roomPrice.id}
                                </div>
                            </td>
                            <td>
                                <div class="data">
                                    <c:choose>
                                        <c:when test="${sessionScope.language eq 'EN'}">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${roomPrice.startDate}"/>
                                        </c:when>
                                        <c:when test="${sessionScope.language eq 'RU'}">
                                            <fmt:formatDate pattern="dd.MM.yyyy" value="${roomPrice.startDate}"/>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </td>
                            <td>
                                <div class="data">
                                    <c:choose>
                                        <c:when test="${sessionScope.language eq 'EN'}">
                                            <fmt:formatDate pattern="MM-dd-yyyy" value="${roomPrice.endDate}"/>
                                        </c:when>
                                        <c:when test="${sessionScope.language eq 'RU'}">
                                            <fmt:formatDate pattern="dd.MM.yyyy" value="${roomPrice.endDate}"/>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </td>
                            <td>
                                <div class="data">
                                        ${roomPrice.cost}
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="addPanel">
                <button data-roomid="${requestScope.roomId}"
                        class="addButton"
                        onclick="addPrice(this)">${addRoomPrice}
                </button>
            </div>
            <c:if test="${not empty requestScope.message}">
                <div class="modal" id="roomPriceNotify" style="display: block;">
                    <div class="modal-content animate">
                       <span class="resultButtons">
                           <c:choose>
                               <c:when test="${requestScope.message eq 'addPrice'}">
                                   <label>${addingPrice}</label>
                               </c:when>
                               <c:when test="${requestScope.message eq 'invalidData'}">
                                   <label>${invalidData}</label>
                               </c:when>
                           </c:choose>
                <a class="noButton" type="submit"
                   href="${pageContext.servletContext.contextPath}/controller?command=showRoomPrices&roomId=${requestScope.roomId}&roomLimit=${requestScope.roomLimit}&roomPage=${requestScope.roomPage}">Ok
                </a>
                       </span>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/fragments/room/addRoomPrice.jsp"/>
<jsp:include page="/WEB-INF/fragments/header/footer.jsp"/>
</body>
</html>
