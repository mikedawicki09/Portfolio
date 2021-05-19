/*global
alert, confirm, console, prompt
*/
 /*jslint devel: true */
function navbarToggle() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
