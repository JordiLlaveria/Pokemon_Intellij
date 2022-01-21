
$(document).ready(function(){
    $("#btnRegister").click(function(e){
        e.preventDefault();
        console.log("click")
        var username = $('#username').val();
        var email = $('#email').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
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
                url: "http://localhost:8080/dsaApp/endpoint/user",
                type: "POST",
                data: JSON.stringify({"name":username, "password": password, "email":email, "charactername": nickname}),
                dataType:'json',

                success: function(data) {
                    alert("Welcome to Pokemon world");
                    console.log("Registered");
                    localStorage.setItem("username",username);
                    localStorage.setItem("charactername",nickname);
                    window.location.href = "avatarChoice.html";

                },
                error: function( xhr, textStatus, errorThrown) {
                    alert("Error. Try again with another name.");
                }
            });
        }
    });
});

