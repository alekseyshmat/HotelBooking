function payOrder(button) {
    document.getElementById('payProve').style.display = 'block';
    document.getElementById('orderId').value = button.dataset.orderid;
}