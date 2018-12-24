function addPrice(button) {
    document.getElementById('addRoomPrice').style.display = 'block';

    document.getElementById('roomId').value = button.dataset.roomid;
    document.getElementById('roomIdHidden').value = button.dataset.roomid;
}