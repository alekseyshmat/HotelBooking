<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="mainHeader.label.makeOrder" var="makeOrder"/>
<fmt:message bundle="${naming}" key="mainHeader.label.welcome" var="welcome"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="table.label.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.paymentType" var="paymentType"/>
<fmt:message bundle="${naming}" key="table.label.paymentType" var="paymentType"/>
<fmt:message bundle="${naming}" key="room.label.apartment" var="apartment"/>
<fmt:message bundle="${naming}" key="room.label.business" var="business"/>
<fmt:message bundle="${naming}" key="room.label.deluxe" var="deluxe"/>
<fmt:message bundle="${naming}" key="room.label.duplex" var="duplex"/>
<fmt:message bundle="${naming}" key="room.label.familyRoom" var="familyRoom"/>
<fmt:message bundle="${naming}" key="room.label.standard" var="standard"/>
<fmt:message bundle="${naming}" key="room.label.president" var="president"/>

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${makeOrder}</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/makeOrderStyle.css">
    <script src="${pageContext.request.contextPath}/js/makeOrder.js"></script>
</head>

<body>
<header>
    <jsp:include page="../fragments/header/mainHeader.jsp"/>
    <h1>${welcome}</h1>
</header>
    <div class="makeOrder">
        <form action="${pageContext.servletContext.contextPath}/controller?command=makeOrder" method="post">
            <div class="row">
                <div class="label">
                    <label for="checkInDate">${checkInDate}</label>
                </div>
                <div class="inputParameter">
                    <input id="checkInDate" type="date" name="checkInDate" required>
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="checkOutDate">${checkOutDate}</label>
                </div>
                <div class="inputParameter">
                    <input id="checkOutDate" type="date" name="checkOutDate" required >
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="typeRoom">${typeRoom}</label>
                </div>
                <div class="inputParameter">
                    <select id="typeRoom" name="typeRoom" required>
                        <option disabled>${typeRoom}</option>
                        <option value="Apartment">${apartment}</option>
                        <option value="Business">${business}</option>
                        <option value="Deluxe">${deluxe}</option>
                        <option value="Duplex">${duplex}</option>
                        <option value="FamilyRoom">${familyRoom}</option>
                        <option value="Standard">${standard}</option>
                        <option value="President">${president}</option>
                    </select>
                </div>
            </div>

            <c:if test="${empty sessionScope.role}">
                <div class="submitHrefButton">
                    <a class="submitBtn" href="${pageContext.request.contextPath}/controller?command=startLogin">${makeOrder}</a>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.role}">
                <div class="submitButton">
                    <input class="submitBtn" type="submit" value="${makeOrder}">
                </div>
            </c:if>

        </form>
    </div>
<jsp:include page="/WEB-INF/fragments/header/footer.jsp"/>
</body>
</html>