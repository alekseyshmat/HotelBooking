function procOrderBtn(button) {
    document.getElementById('processOrder').style.display='block';

    document.getElementById('procId').value = button.dataset.procId;
    document.getElementById('procName').value = button.dataset.name;
    document.getElementById('procCheckInDate').value = button.dataset.indate;
    document.getElementById('procCheckOutDate').value = button.dataset.outdate;
    document.getElementById('procType').value = button.dataset.type;
}

function completeOrderBtn(button) {
    document.getElementById('completeOrder').style.display='block';

    document.getElementById('activeId').value = button.dataset.activeid;
    document.getElementById('activeName').value = button.dataset.name;
    document.getElementById('activeCheckInDate').value = button.dataset.indate;
    document.getElementById('activeCheckOutDate').value = button.dataset.outdate;
    document.getElementById('activeRoomNumber').value = button.dataset.roomnumber;
    document.getElementById('activeCost').value = button.dataset.cost;
    document.getElementById('activePaymentStatus').value = button.dataset.paystatus;

}

function showDetailsBtn(button) {
    document.getElementById('showDetails').style.display='block';

    document.getElementById('completeName').value = button.dataset.name;
    document.getElementById('completeCheckInDate').value = button.dataset.indate;
    document.getElementById('completeCheckOutDate').value = button.dataset.outdate;
    document.getElementById('completeInvoiceDate').value = button.dataset.invoicedate;
    document.getElementById('completeRoomNumber').value = button.dataset.roomnumber;
    document.getElementById('completeCost').value = button.dataset.cost;
}


