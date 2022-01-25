
$(document).ready(function(){
    $(".form").submit(function(){
        var username = $('#username').val();
        var password = $('#password').val();
            $.ajax({
                headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
                url: "http://147.83.7.204:8080/dsaApp/endpoint/login",
                type: "POST",
                data: JSON.stringify({"username": username, "password": password}),
                dataType: 'json',
                success: function(data) {
                    alert("Welcome back!");
                    myStorage.setItem("username", data.username);
                    myStorage.setItem("password", data.password);
                    window.location.href = "home.html"; //Anem a la pagina principal
                },
                error: function( xhr, textStatus, errorThrown) {
                        alert(xhr.responseText);
                }
            })
    });
});






