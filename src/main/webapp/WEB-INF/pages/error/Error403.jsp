<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>

<fmt:message bundle="${naming}" key="error.label.error" var="error"/>
<fmt:message bundle="${naming}" key="error.label.forbidden" var="forbidden"/>
<fmt:message bundle="${naming}" key="error.label.info403" var="info403"/>
<fmt:message bundle="${naming}" key="error.label.backTo" var="backTo"/>
<fmt:message bundle="${naming}" key="error.label.mainPage" var="mainPage"/>


<html>
<head>
    <title>${error} 403</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon/favicon.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/errorStyle.css">
</head>
<body>
<div class="infoError">
    <H1>${error} 403. ${forbidden}</H1>
    <h2>${info403}</h2>
    <h3>${backTo} <a href="${pageContext.servletContext.contextPath}/controller?command=signOut"> ${mainPage}</a></h3>
</div>
<jsp:include page="/WEB-INF/fragments/header/footer.jsp"/>
</body>
</html>
