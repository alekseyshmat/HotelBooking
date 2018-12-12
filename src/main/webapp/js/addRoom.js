var addRoom = document.getElementById('addRoom');

// When the user clicks anywhere outside of the addRoom, close it
window.onclick = function(event) {
    if (event.target === addRoom) {
        addRoom.style.display = "none";
    }
};