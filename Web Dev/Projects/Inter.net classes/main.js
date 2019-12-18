function check(){
var question1 = document.quiz.question1.value;
var question2 = document.quiz.question2.value;
var question3 = document.quiz.question3.value;
var question4 = document.quiz.question4.value;
var correct = 0;

    if (question1 == "q1answer3") {
        correct++;
    }

    if (question2 == "q2answer4") {
        correct++;
    }

    if(question3 == "q3answer1") {
        correct++;
    }

    if (question4 == "q4answer3") {
        correct++;
    }
    var isIE = /*@cc_on!@*/false || !!document.documentMode;
    document.getElementById("after_submit").style.visibility="visible";
    document.getElementById("number_correct").innerHTML = "You got " + correct + "/4 questions correct."
    if(isIE){
        document.getElementById("number_correct").innerHTML = "The quiz script doesn't work with IE :( . Use a real browser.";
    }
 

}

function toggleDarkLight(){
    // The body
    var body = document.querySelector("body"); 
    currentClass = body.className; // get current mode
    
    // if light mode
    if(currentClass != "dark-mode"){
        // dark button
        var button = document.getElementById("darkbutton");
        button.innerHTML="";
        button.className="far fa-sun";

        // body
        body.className ="dark-mode";

        // body table
        var table = document.querySelector("table");
        table.className = "table dark-mode";
    
        // Sidenav
        var sidenav = document.querySelector(".sidenav");
        sidenav.style.backgroundColor =  "#212529";
        // Sidenav anchors
        var sidenavanchors = document.querySelector(".sidenav").querySelectorAll("a");
        for (var i = 0; i < sidenavanchors.length; i++) {
            sidenavanchors[i].style.color = "rgb(218, 200, 200)";
        }
        // Sidenav h5's
        var sidenavh5 = document.querySelector(".sidenav").querySelectorAll("h5");
        for (var i = 0; i < sidenavh5.length; i++) {
            sidenavh5[i].style.color = "rgb(218, 200, 200)";
        }
    } else {
        // dark button
        var button = document.getElementById("darkbutton");
        button.innerHTML="";
        button.className="far fa-moon";


        // body
        body.className = "light-mode";


        // body table
        var table = document.querySelector("table");
        table.className = "table light-mode";
        
        // Sidenav
        var sidenav = document.querySelector(".sidenav");
        sidenav.style.backgroundColor =  "#f1f1f1";
        // Sidenav anchors
        var sidenavanchors = document.querySelector(".sidenav").querySelectorAll("a");
        for (var i = 0; i < sidenavanchors.length; i++) {
            sidenavanchors[i].style.color = "black";
        }
        // Sidenav h5's
        var sidenavh5 = document.querySelector(".sidenav").querySelectorAll("h5");
        for (var i = 0; i < sidenavh5.length; i++) {
            sidenavh5[i].style.color = "black";
        }
       
    }
    

}
