
/*function to open the skill tabs*/
function openTab(page, elmnt, skillType) {
    var i, tabContent;
    /*grabs all elements that have the class tabContent*/
    tabContent = document.getElementsByClassName("tabContent");
    var slider = document.getElementById(skillType);
    /*loops through each of the selected elements and hides them*/
    for (i = 0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }
    var tabButton = document.getElementsByClassName("tabButton");
    for (i = 0; i < tabButton.length; i++) {
        tabButton[i].style.backgroundColor = "#1f2833";
        tabButton[i].style.color = "white";
        tabButton[i].style.borderTop = "0px";
    }

    document.getElementById(page).style.display = "block";
    elmnt.style.backgroundColor = "white";
    elmnt.style.color = "black";
    elmnt.style.border = "2px solid lightgray";
    elmnt.style.borderBottom = "0px";
    elmnt.style.borderTop = "3px solid #1f2833";

    count = 0;

}

var prevScrollpos = window.pageYOffset;
window.onscroll = function () {
    var currentScrollPos = window.pageYOffset;
    var navigation = document.querySelector("#nav");
    if (prevScrollpos > currentScrollPos) {
        navigation.style.display = "block";
    }
    else {
        navigation.style.display = "none";
    }
    prevScrollpos = currentScrollPos;
}

/*function to remove tab content*/
function cancelTab(page, elmnt) {
    var cancelTab = document.getElementById(page).style.display = "none";
    var tabButton = document.getElementsByClassName("tabButton");
    for (i = 0; i < tabButton.length; i++) {
        tabButton[i].style.backgroundColor = "#1f2833";
        tabButton[i].style.color = "white";
        tabButton[i].style.borderTop = "0px";
    }
}


var count = 0;
function sliderScript(num, skillType) {
    var listItem = document.getElementsByClassName(skillType);
    count += num;
    for (var i of listItem) {
        if (count == 0) {
            i.style.left = "0%";
        }
        if (count == 1) {
            if (skillType == 'frameSkill') {
                i.style.left = "-35%";
                count = 1;
            }
            else {
                i.style.left = "-75%";
            }
        }
        if (count == 2) {
            if (skillType == 'frameSkill') {
                i.style.left = "-35%";
                count = 1;
            }
            else {
                i.style.left = "-170%";
            }
        }
        if (count > 2) {
            if (skillType == 'frameSkill') {
                i.style.left = "-35%";
                count = 0;
            }
            else {
                i.style.left = "-170%";
                count = 2;
            }
        }
        if (count < 0) {
            i.style.left = "0%";
            count = 0;
        }
    }

}

$(document).ready(function () {
    var scrollLink = $('.scroll');
    scrollLink.click(function (e) {
        e.preventDefault();
        $('body,html').animate({
            scrollTop: $(this.hash).offset().top
        }, 1200)
    })
})


function showNav() {
    const navbarList = document.querySelector(".my-nav-list");
    const menuBtn = document.querySelector(".menu-btn");
    navbarList.classList.add("active");
    menuBtn.classList.add("hide");
}
function removeNav() {
    const navbarList = document.querySelector(".my-nav-list");
    const menuBtn = document.querySelector(".menu-btn");
    navbarList.classList.remove("active");
    menuBtn.classList.remove("hide");
}






