
$(document).ready(function(){
    myStorage = window.localStorage;
    $("#btnRegister").click(function(e){
        e.preventDefault();
        var username = $('#username').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        var email = $('#email').val();
        var nickname = $('#nickname').val();

        if (password != password2){ //Check if the passwords match
            alert("Password doesn't match")
        }
        else if (username == null || password == null || password2 == null || email == null) {//Check that there's no empty spaces
            alert("Please fill all the spaces")
        }

        else {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                //New User
                url: "/dsaApp/endpoint/user",
                type: "POST",
                data: JSON.stringify({"name":username, "password": password, "email":email, "charactername": nickname}),
                dataType:'json',

                success: function(data) {
                    alert("Welcome to Pokemon world");
                    console.log("Registered");
                    //myStorage.setItem("username", data.username);
                    //myStorage.setItem("password", data.password);
                    window.location.href = "character.html";

                },
                error: function(error){
                    message = '"error"'
                    console.log("Error",error);
                    alert("Error");
                },
            });
        }
    });
});

