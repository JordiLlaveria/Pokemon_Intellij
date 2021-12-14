
$(document).ready(function(){
    myStorage = window.localStorage;
    var username = localStorage.getItem("username");
    $("#buttonpokeball").click(function(){
        $ajax({
            headers: {'Accept': 'application/json',
                'Content-Type': 'application/json'},
                url: BASE_URI.concat("/auth/shop/buyObject"),
                type: "POST",
                data: JSON.stringify({"object": "pokeball", "username": username}),
                dataType: 'json',
                success: function(data) {
                    alert("Superball correctly bought"); //necessitem dir-li les monedes que li queden
                        window.location.href = "shop.html";
                }
                error: function(error){ //preguntar dema
                    alert("You don't have enough money");
                }
        });

    });
    $("#buttonsuperball").click(function(){
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
                    }
                    error: function(error){ //preguntar dema
                        alert("You don't have enough money");
                    }
            });

    });
    $("#buttonpotion").click(function(){
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
                        }
                        error: function(error){ //preguntar dema
                            alert("You don't have enough money");
                        }
                });

    });
    $("#buttonsuperpotion").click(function(){
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
                        }
                        error: function(error){ //preguntar dema
                            alert("You don't have enough money");
                        }
                });

    });
});
