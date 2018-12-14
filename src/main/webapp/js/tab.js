function openCity(evt, tableName) {
    var i, rightColumn, tabLinks;
    rightColumn = document.getElementsByClassName("rightColumn");
    for (i = 0; i < rightColumn.length; i++) {
        rightColumn[i].style.display = "none";
    }
    tabLinks = document.getElementsByClassName("tabLinks");
    for (i = 0; i < tabLinks.length; i++) {
        tabLinks[i].className = tabLinks[i].className.replace(" active", "");
    }
    document.getElementById(tableName).style.display = "block";
    evt.currentTarget.className += " active";
}