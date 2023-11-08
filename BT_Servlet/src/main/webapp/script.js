
function callFunction(){
    var x = document.getElementById("myList2");
  var y = document.getElementById("myList");
  var z = document.getElementById("myList3");
    if(z.style.display === "none"){
        z.style.display = "block";
        x.style.display = "none";
        y.style.display = "none";

    } else {
        z.style.display = "none";
        x.style.display = "block";
    y.style.display = "none";
    }
}
function showSubmenu() {
    var submenu = document.getElementById('submenu');
   if (submenu.style.display === 'none'){
    submenu.style.display = "block";
   } else {
    submenu.style.display = "none";
   }
}
