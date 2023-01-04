    function showElement(element) {
        if (element === "student"){
            document.getElementById("librarian").style.display = "none";
            document.getElementById("student").style.display = "block";
        }
        if (element === "librarian") {
            document.getElementById("student").style.display = "none";
            document.getElementById("librarian").style.display = "block";
        }
        if (element === "select") {
            document.getElementById("student").style.display = "none";
            document.getElementById("librarian").style.display = "none";
        }
    }

    function Mismatch() {
        var pw1 = document.getElementById("myInput1").value;
        var pw2 = document.getElementById("myInput2").value;

        if(pw1 != pw2) {
            document.getElementById("message1").innerHTML = "Passwords are not same";
            window. scrollTo(0, 0);
            return false;
        }
    }

    function PassForm(){
        let str = document.getElementById("myInput1").value;
        if (str.search("helmepa") != -1){
            document.getElementById("message4").innerHTML = "Password must not contain keyword 'helmepa'";
            window. scrollTo(0, 0);
            return false;
        }
        else if (str.search("uoc") != -1){
            document.getElementById("message4").innerHTML = "Password must not contain keyword 'uoc'";
            window. scrollTo(0, 0);
            return false;
        }
        else if (str.search("tuc") != -1){
            document.getElementById("message4").innerHTML = "Password must not contain keyword 'tuc'";
            window. scrollTo(0, 0);
            return false;
        }
    }

    function PassStrength(){
        let pw = document.getElementById("myInput1").value;
        let sml = 0;
        let cap = 0;
        let sym = 0;
        let num = pw.replace(/[^0-9]/g, '').length;
        for(var i = 0; i < pw.length; i++){
            if (pw.charAt(i).toLowerCase() == pw.charAt(i) && pw.charAt(i).toUpperCase() != pw.charAt(i)) {
                sml++;
            }else if(pw.charAt(i).toUpperCase() == pw.charAt(i) && pw.charAt(i).toLowerCase() != pw.charAt(i)){
                cap++;
            }else if (pw.charAt(i).toUpperCase() == pw.charAt(i).toLowerCase() && isNaN(pw.charAt(i))) {
                sym++;
            }
        }
        if(num>(parseInt(pw.length/2))){
            document.getElementById("sw").innerHTML="Weak password";
            returnToPreviousPage();
            return false;
        }else if(cap >= 1 && sml >= 1 && sym >= 2){
            document.getElementById("ss").innerHTML="Strong password";
            return true;
        }else{
            document.getElementById("sm").innerHTML="Medium password";
            return true;
        }
    }

    function ShowPass1() {
        var x = document.getElementById("myInput1");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }

    function ShowPass2() {
        var x = document.getElementById("myInput2");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }

