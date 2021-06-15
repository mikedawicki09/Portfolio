function changeTab(page) {
    var indicator = document.querySelector(".tab-indicator");

    if (page == "tools") {
        if (indicator.style.left = "16.5%") {
            indicator.style.left = "110%";
        }
        if (indicator.style.left = "64%") {
            indicator.style.left = "40%";
        }
    }
    if (page == "languages") {
        if (indicator.style.left = "23%") {
            indicator.style.left = "16.5%";
        }
        if (indicator.style.left = "64%") {
            indicator.style.left = "16.5%";
        }
    }
    if (page == "frameworks") {
        if (indicator.style.left = "23%") {
            indicator.style.left = "64%";
        }
        if (indicator.style.left = "16.5%") {
            indicator.style.left = "63.5%";
        }
    }
}


/*function to open the skill tabs*/
function openTab(page, elmnt, skillType) {
    changeTab(page);
    var i, tabContent;
    /*grabs all elements that have the class tabContent*/
    tabContent = document.getElementsByClassName("tabContent");
    var tabButton = document.getElementsByClassName("tabButton");

    for (i = 0; i < tabButton.length; i++) {
        tabButton[i].style.color = "black";
    }
    var slider = document.getElementById(skillType);
    /*loops through each of the selected elements and hides them*/
    for (i = 0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }


    document.getElementById(page).style.display = "block";
    elmnt.style.color = "#FA991C";

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




var count = 0;
function sliderScript(num, skillType) {
    var listItem = document.getElementsByClassName(skillType);
    count += num;
    for (var i of listItem) {
        switch (count) {
            case 0:
                if (count == 0) { i.style.top = "0%"; }
                break;
            case 1:
                (skillType == 'frameSkill') ? i.style.top = "-95%" : i.style.top = "-95%";
                break;
            case 2:
                (skillType == 'frameSkill') ? i.style.top = "-190%" : i.style.top= "-190%";
                break;
            case 3:
                (skillType == 'frameSkill') ? count = 2 : i.style.top = "-285%";
                break;
            case 4:
                (skillType == 'frameSkill') ? count = 2 : i.style.top = "-380%";
                break;
            case 5: (skillType == "frameSkill") ? count = 2 : i.style.top = "-477%";
                break;
        }
        if (count < 0) {
            count = 0;
        }
        if (count > 5) {
            count = 5;
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

window.onscroll = function () { myFunction() };

function myFunction() {
    if (document.body.scrollTop > 550 || document.documentElement.scrollTop > 550) {
        document.getElementById("floatButton").style.display = "block";
        document.getElementById("nav").style.display = "none";
    } else {
        document.getElementById("floatButton").style.display = "none";
        document.getElementById("nav").style.display = "block";
    }
}




