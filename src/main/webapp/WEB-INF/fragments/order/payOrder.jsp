<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="naming" var="naming"/>
<fmt:message bundle="${naming}" key="label.provePayment" var="provePayment"/>
<fmt:message bundle="${naming}" key="button.label.no" var="no"/>
<fmt:message bundle="${naming}" key="button.label.yes" var="yes"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/processOrder.js"></script>
</head>
<body>
<div id="payProve" class="modal">

    <div class="modal-content animate">
        <form action="${pageContext.request.contextPath}/controller?command=updateBalance" method="post">
            <input name="orderId" id="orderId" type="hidden" value=""/>
            <label class="paymentLabel"><b>${provePayment}</b></label>

            <div>
            <span class="resultButtons">
                <button class="yesButton" type="submit">${yes}
                </button>
            </span>
            </div>
        </form>
        <span class="resultButtons">
                <button class="noButton" type="submit"
                        onclick="document.getElementById('payProve').style.display='none'">${no}
                </button>
            </span>
    </div>

</div>
</body>
</html>
