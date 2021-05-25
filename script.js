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
    for (i = 0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }
    var tabButton = document.getElementsByClassName("tabButton");
    for (i = 0; i < tabButton.length; i++) {
        tabButton[i].style.backgroundColor = "#557A95";
        tabButton[i].style.borderTop = "0px";
    }


    document.getElementById(page).style.display = "block";
    elmnt.style.backgroundColor = "white";
    elmnt.style.color = "black";
    elmnt.style.border = "2px solid lightgray";
    elmnt.style.borderBottom = "0px";
    elmnt.style.borderTop = "3px solid #557A95";
}

/*function to remove tab content*/
function cancelTab(page, elmnt) {
    var cancelTab = document.getElementById(page).style.display = "none";
    var tabButton = document.getElementsByClassName("tabButton");
    for (i = 0; i < tabButton.length; i++) {
        tabButton[i].style.backgroundColor = "#557A95";
        tabButton[i].style.borderTop = "0px";
    }
}


function fade(page) {
    var opacity = 0;
    var fade = document.getElementById(page);
    fade.style.display = 'block';
    //var timer = setInterval(function () {
    //    if (opacity < 1) {
    //        opacity += 0.1;
    //        fade.style.opacity = opacity;
    //    }
    //}, 80); 
}
function scrollToTop() {
    var position =
        document.body.scrollTop || document.documentElement.scrollTop;
 if (position) {
        window.scrollBy(0, -Math.max(1, Math.floor(position / 10)));
        scrollAnimation = setTimeout("scrollToTop()", 30);
    } else clearTimeout(scrollAnimation);
}
