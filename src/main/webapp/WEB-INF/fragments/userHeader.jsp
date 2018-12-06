<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/adminStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<div class="buttons">
    <a href="controller?command=showProfile">{Profile}</a>
</div>
<div class="buttons">
    <a href="controller?command=showOrders">{orders}</a>
</div>
<div class="buttons">
    <a href="controller?command=showBalance">{Balance}</a>
</div>


</body>
</html>




