
$(document).ready(function(){
    myStorage = window.localStorage;
    $("#btnLogIn").click(function(e){
    e.preventDefault();

        var username = $('#username').val();
        var password = $('#password').val();
        if (username == null || password == null){
            alert("Fill the empty spaces");
        }
        else{
            $.ajax({
                headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
                url: "http://localhost:8080/dsaApp/endpoint/login",
                type: "POST",
                data: JSON.stringify({"username": username, "password": password}),
                dataType: 'json',
                success: function(data) {
                    alert("Welcome back!");
                    myStorage.setItem("username", data.username);
                    myStorage.setItem("password", data.password);
                    window.location.href = "home.html"; //Anem a la pagina principal
                },
                error: function( jqXhr, textStatus, errorThrown ){
                        console.log( errorThrown );
                        alert("The user doesn't exist or wrong password")
                }
            })

        }

    });
});


