function edit(button) {
    document.getElementById('editRoom').style.display = 'block';

    document.getElementById('roomId').value = button.id;
    document.getElementById('editRoomNumber').value = button.dataset.roomnumber;
    document.getElementById('editTypeRoom').value = button.dataset.roomtype;
}

function changeStatus(button) {

    // button.className = button.className.replace(" active", "");
    // alert(button.className);
    button.currentTarget.className += " active";
    // alert(button.currentTarget.className);
}
