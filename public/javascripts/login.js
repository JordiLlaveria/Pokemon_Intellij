
var BASE_URI = "http://localhost:8080/dsaApp"
$(document).ready(function(){
    myStorage = window.localStorage;

       $("#btnLogIn").click(function(){
           e.preventDefault();
           var username = $('#username').val();
           var password = $('#password').val();
           if (username == null || password == null){
               alert("Fill the empty spaces");
           }
           else{
                $ajax({
                        headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'},
                        url: BASE_URI.concat("/auth/login"),
                        type: "POST",
                        data: JSON.stringify({"username": username, "password": password}), //No tinc clar com crear la classe credencials aqui dins
                        dataType: 'json',
                        success: function(data) {
                            alert("Welcome back!");
                            myStorage.setItem("username", data.username);
                            myStorage.setItem("password", data.password);
                            window.location.href = "home.html"; //Anem a la pagina principal
                        }
                        error: function(error){
                            alert("Error: wrong username/password");
                        }
           })

       }
    });
});


