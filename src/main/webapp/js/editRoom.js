function edit(button) {
    document.getElementById('editRoom').style.display = 'block';

    document.getElementById('roomId').value = button.id;
    document.getElementById('editRoomNumber').value = button.dataset.roomnumber;
    document.getElementById('editTypeRoom').value = button.dataset.roomtype;
}