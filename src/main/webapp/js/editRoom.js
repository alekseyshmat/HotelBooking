function edit(button) {
    document.getElementById('editRoom').style.display = 'block';

    document.getElementById('roomId').value = button.id;
    document.getElementById('editRoomNumber').value = button.dataset.roomnumber;
    document.getElementById('editTypeRoom').value = button.dataset.roomtype;
}

function deleteRoom(button) {
    document.getElementById('deleteProve').style.display = 'block';

    document.getElementById('deletedRoomId').value = button.id;
}
