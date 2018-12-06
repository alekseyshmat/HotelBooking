<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<head>
    <title>{makeOrder}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/makeOrderStyle.css">
</head>

<body>
<header>
    <jsp:include page="../fragments/mainHeader.jsp"/>
</header>
<div class="back">
    <div class="makeOrder">
        <form>
            <div class="row">
                <div class="label">
                    <label>{checkInDate}</label>
                </div>
                <div class="inputParameter">
                    <input type="date" name="checkInDate">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label>{checkOutDate}</label>
                </div>
                <div class="inputParameter">
                    <input type="date" name="checkOutDate">
                </div>
            </div>

            <div class="row">
                <div class="label">
                    <label for="typeRoom">{typeRoom}</label>
                </div>
                <div class="inputParameter">
                    <select id="typeRoom" name="typeRoom">
                        <option disabled>{typeRoom}</option>
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
                    <label for="placeNumber">{placeNumber}</label>
                </div>
                <div class="inputParameter">
                    <select id="placeNumber" name="placeNumber">
                        <option disabled>{placeNumber}</option>
                        <option value="Single">Single</option>
                        <option value="DoubleTwin">Double twin</option>
                        <option value="Twin">Twin</option>
                        <option value="Triple">Triple</option>
                        <option value="Quadriple">Quadriple</option>
                    </select>
                </div>
            </div>


            <div class="submitButton">
                <input class="submitBtn" type="submit" value="{makeOrder}">
            </div>

        </form>
    </div>
</div>
</body>
</html>