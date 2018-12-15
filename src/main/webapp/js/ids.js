function edit() {
    document.getElementById('editRoom').style.display = 'block';
    var roomId = document.getElementById('btnRoom');

    document.getElementById('roomId').value = roomId.value;
    document.getElementById('editRoomNumber').value = roomId.dataset.roomnumber;
    document.getElementById('typeRoom').value = roomId.dataset.roomtype;

}
