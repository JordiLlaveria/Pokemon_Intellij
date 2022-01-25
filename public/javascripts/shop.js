
$(document).ready(function(){
    myStorage = window.localStorage;
    var username = localStorage.getItem("username");




    $("#buttonpokeball").click(function(){
        if(username == null){
            $.ajax({
                headers: {'Accept': 'application/json',
                    'Content-Type': 'application/json'},
                    url: "http://localhost:8080/dsaApp/endpoint/auth/shop/buyObject",
                    type: "POST",
                    body: JSON.stringify({"object": "pokeball", "username": username}),
                    dataType: 'json',
                    success: function(data) {
                        alert("Superball correctly bought"); //necessitem dir-li les monedes que li queden
                            window.location.href = "shop.html";
                    },
                    error: function(error){ //preguntar dema
                        alert("You don't have enough money");
                    }
            });
        }else{alert("Please LogIn or SignIn")}
    });
    $("#buttonsuperball").click(function(){
        if(username != null){
            $ajax({
                headers: {'Accept': 'application/json',
                    'Content-Type': 'application/json'},
                    url: BASE_URI.concat("/auth/shop/buyObject"),
                    type: "POST",
                    data: JSON.stringify({"object": "superball", "username": username}),
                    dataType: 'json',
                    success: function(data) {
                        alert("Superball correctly bought"); //necessitem dir-li les monedes que li queden
                            window.location.href = "shop.html";
                    },
                    error: function(error){ //preguntar dema
                        alert("You don't have enough money");
                    }
            });
        }else{alert("Please LogIn or SignIn")}
    });
    $("#buttonpotion").click(function(){
        if(username != null){
                $ajax({
                    headers: {'Accept': 'application/json',
                        'Content-Type': 'application/json'},
                        url: BASE_URI.concat("/auth/shop/buyObject"),
                        type: "POST",
                        data: JSON.stringify({"object": "potion", "username": username}),
                        dataType: 'json',
                        success: function(data) {
                            alert("Superball correctly bought"); //necessitem dir-li les monedes que li queden
                                window.location.href = "shop.html";
                        },
                        error: function(error){ //preguntar dema
                            alert("You don't have enough money");
                        }
                });
        }else{alert("Please LogIn or SignIn")}
    });
    $("#buttonsuperpotion").click(function(){
        if(username != null){
                $ajax({
                    headers: {'Accept': 'application/json',
                        'Content-Type': 'application/json'},
                        url: BASE_URI.concat("/auth/shop/buyObject"),
                        type: "POST",
                        data: JSON.stringify({"object": "superpotion", "username": username}),
                        dataType: 'json',
                        success: function(data) {
                            alert("Superball correctly bought"); //necessitem dir-li les monedes que li queden
                                window.location.href = "shop.html";
                        },
                        error: function(error){ //preguntar dema
                            alert("You don't have enough money");
                        }
                });
        }else{alert("Please LogIn or SignIn")}
    });

});
