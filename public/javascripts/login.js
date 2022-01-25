
$(document).ready(function(){
    $(".form").submit(function(){
    e.preventDefault();
        var username = $('#username').val();
        var password = $('#password').val();
            $.ajax({
                headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
                url: "http://localhost:8080/dsaApp/endpoint/login",
                type: "POST",
                data: JSON.stringify({"username": username, "password": password}),
                dataType: 'json',
                success: function(data) {
                    alert("Welcome back!");
                    localStorage.setItem("username", data.username);
                    localStorage.setItem("password", data.password);
                    window.location.href = "home.html"; //Anem a la pagina principal
                },
                error: function( xhr, textStatus, errorThrown) {
                        alert(xhr.responseText);
                }
            })
    });
});






