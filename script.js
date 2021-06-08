function changeTab(page) {
    var indicator = document.querySelector(".tab-indicator");
    if (page == "tools") {
        if (indicator.style.left = "1.6%") {
            indicator.style.left = "30%";
        }
        if (indicator.style.left = "64%") {
            indicator.style.left = "33%";
        }
    }
    if (page == "languages") {
        if (indicator.style.left = "23%") {
            indicator.style.left = "1.6%";
        }
        if (indicator.style.left = "64%") {
            indicator.style.left = "1.6%";
        }
    }
    if (page == "frameworks") {
        if (indicator.style.left = "23%") {
            indicator.style.left = "64%";
        }
        if (indicator.style.left = "1.6%") {
            indicator.style.left = "64%";
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

    count = 1;

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

}


var count = 0;
function sliderScript(num, skillType) {
    var listItem = document.getElementsByClassName(skillType);
    var addedLeft = 0;
    var skillCards = document.querySelector(".myskills li");
    for (var k = 0; k < skillCards.length; k++) {
        if (skillCards.style.width == "85%") {
            addedLeft = -55;
        }
    }
    count += num;
    for (var i of listItem) {
        switch (count) {
            case 0:
                if (count == 0) { i.style.left = "0%";}
                break;
            case 1:
                (skillType == 'frameSkill') ? i.style.left = "-45%" : i.style.left = "-80%";
                break;
            case 2:
                (skillType == 'frameSkill') ? i.style.left = "-80%"  : i.style.left = "-165%";
                break;
            case 3:
                (skillType == 'frameSkill') ?  count = 2 : i.style.left = "-255%";
                break;
            case 4:
                (skillType == 'frameSkill') ?  count = 2 : i.style.left = "-350%";
                break;
            case 5: (skillType == "frameSkill") ?  count = 2 : i.style.left = "-440%";
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






