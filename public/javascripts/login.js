
$(document).ready(function(){
    $( ".input" ).focusin(function() {
      $( this ).find( "span" ).animate({"opacity":"0"}, 200);
    });

    $( ".input" ).focusout(function() {
      $( this ).find( "span" ).animate({"opacity":"1"}, 300);
    });
    myStorage = window.localStorage;
    $(".login").submit(function(){
      $(this).find(".submit i").removeAttr('class').addClass("fa fa-check").css({"color":"#fff"});
      $(".submit").css({"background":"#2ecc71", "border-color":"#2ecc71"});
      $(".feedback").show().animate({"opacity":"1", "bottom":"-80px"}, 400);
      $("input").css({"border-color":"#2ecc71"});
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






