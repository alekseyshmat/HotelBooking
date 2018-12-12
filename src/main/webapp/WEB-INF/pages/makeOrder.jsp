<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="mainHeader.label.makeOrder" var="makeOrder"/>
<fmt:message bundle="${naming}" key="table.label.checkInDate" var="checkInDate"/>
<fmt:message bundle="${naming}" key="table.label.checkOutDate" var="checkOutDate"/>
<fmt:message bundle="${naming}" key="user.label.login.typeRoom" var="typeRoom"/>
<fmt:message bundle="${naming}" key="table.label.placeNumber" var="placeNumber"/>
<fmt:message bundle="${naming}" key="table.label.paymentType" var="paymentType"/>

<html>

<head>
    <title>${makeOrder}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/makeOrderStyle.css">
</head>

<body>
<header>
    <jsp:include page="../fragments/header/mainHeader.jsp"/>
</header>
    <div class="makeOrder">
        <form action="${pageContext.servletContext.contextPath}/controller?command=makeOrder" method="post">
            <div class="row">
                <div class="label">
                    <label for="checkInDate">${checkInDate}</label>
                </div>
                <div class="inputParameter">
                    <input id="checkInDate" type="date" name="checkInDate">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="checkOutDate">${checkOutDate}</label>
                </div>
                <div class="inputParameter">
                    <input id="checkOutDate" type="date" name="checkOutDate">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="typeRoom">${typeRoom}</label>
                </div>
                <div class="inputParameter">
                    <select id="typeRoom" name="typeRoom">
                        <option disabled>${typeRoom}</option>
                        <option value="Apartment">Apartment</option>
                        <option value="Business">Business</option>
                        <option value="Deluxe">Deluxe</option>
                        <option value="Duplex">Duplex</option>
                        <option value="FamilyRoom">Family room</option>
                        <option value="Standard">Standard</option>
                        <option value="President">President</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="placeNumber">${placeNumber}</label>
                </div>
                <div class="inputParameter">
                    <select id="placeNumber" name="placeNumber">
                        <option disabled>${placeNumber}</option>
                        <option value="Single">Single</option>
                        <option value="DoubleTwin">Double twin</option>
                        <option value="Twin">Twin</option>
                        <option value="Triple">Triple</option>
                        <option value="Quadriple">Quadriple</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="paymentType">${paymentType}</label>
                </div>
                <div class="inputParameter">
                    <select id="paymentType" name="paymentType">
                        <option disabled>${paymentType}</option>
                        <option value="creditCard">Credit card</option>
                        <option value="cash">cash</option>
                    </select>
                </div>
            </div>
            <div class="submitButton">
                <input class="submitBtn" type="submit" value="${makeOrder}">
            </div>

        </form>
    </div>
</body>
</html>