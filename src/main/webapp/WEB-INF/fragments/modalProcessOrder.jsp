<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/modalStyle.css">
    <script src="${pageContext.request.contextPath}/js/modal.js"></script>
</head>
<body>
<div id="id01" class="modal">
    <form class="modal-content animate" action="#">
        <div class="modalContainer">
            <label for="name"><b>Username</b></label>
            <input type="text" id="name" name="uname" value="{Name} {Surname}"
                   readonly>
            <label><b>{CheckInDate}</b></label>
            <input type="text" name="checkInDate" value="{checkInDate}"
                   readonly>
            <label><b>{CheckOutDate}</b></label>
            <input type="text" name="{checkOutDate}" readonly>
            <label><b>{Type}</b></label>
            <input type="text" name="type" value="{type}" readonly>
            <label for="typeRoom"><b>TypeRoom</b></label>
            <input id="typeRoom" type="text" name="type" value="{type}" readonly>
            <label for="chooseTypeRoom"><b>{chooseTypeRoom}</b></label>
            <div>
                <select class="chooseTypeModal" id="chooseTypeRoom" name="typeRoom">
                    <option disabled>${typeRoom}</option>
                    <option>${typeRoom}</option>
                </select>
                <button class="prcButton" type="submit">Process</button>
                <button class="cancelButton" type="submit">Cancel</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
