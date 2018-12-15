var rowV;

function edit() {
    // var row = row(x);
    alert(rowV);
    document.getElementById('editRoom').style.display = 'block';

    var rooms = document.getElementsByName('nameRoom');
    var roomTypes = document.getElementsByName('nameRoomType');
    document.getElementById('valueId').value = rooms[4-1].innerHTML;
    document.getElementById('typeRoom').value = roomTypes[4-1].innerHTML;

}

function row(x) {
     rowV = x.rowIndex;
}