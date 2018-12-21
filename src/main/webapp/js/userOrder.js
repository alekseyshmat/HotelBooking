function payOrder(button) {
    document.getElementById('payProve').style.display = 'block';

    document.getElementById('orderId').value = button.dataset.orderid;
}

function cancelOrder(button) {
    document.getElementById('cancelProve').style.display = 'block';

    document.getElementById('cancelOrderId').value = button.dataset.orderid;
}

function showDetailsBtn(button) {
    document.getElementById('showDetails').style.display = 'block';

    document.getElementById('completeName').value = button.dataset.name;
    document.getElementById('completeCheckInDate').value = button.dataset.indate;
    document.getElementById('completeCheckOutDate').value = button.dataset.outdate;
    document.getElementById('completeInvoiceDate').value = button.dataset.invoicedate;
    document.getElementById('completeRoomNumber').value = button.dataset.roomnumber;
    document.getElementById('completeCost').value = button.dataset.cost;
}