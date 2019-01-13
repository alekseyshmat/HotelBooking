var addRoom = document.getElementById('addRoom');

window.onclick = function(event) {
    if (event.target === addRoom) {
        addRoom.style.display = "none";
    }
};

function addingRoom() {
    document.getElementById('addRoom').style.display='none';
    document.getElementById('addRoomNotify').style.display='block';
}