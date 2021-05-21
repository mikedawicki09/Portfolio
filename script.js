/*global
alert, confirm, console, prompt
*/
 /*jslint devel: true */

/*function to toggle the menu bar*/
function navbarToggle() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

/*function to open the skill tabs*/
function openTab(page, elmnt) {
    var i, tabContent, selectedTab;
    /*grabs all elements that have the class tabContent*/
    tabContent = document.getElementsByClassName("tabContent");
    /*loops through each of the selected elements and hides them*/
    for(i =0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }
    
    selectedTab = document.getElementById(page).style.display = "block";


}
