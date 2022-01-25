$(document).ready(function(){
    var charactername = localStorage.getItem("charactername");
    $('#title').text("Hello "+charactername+"!");
    $("button").click(function(e){
        e.preventDefault();
        var pokemon = $(this).val();
        console.log(pokemon);
        localStorage.setItem("pokemonInitial",pokemon);
        var avatar = localStorage.getItem("avatar");
        var username = localStorage.getItem("username");
        var charactername = localStorage.getItem("charactername");
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "http://147.83.7.204:8080/dsaApp/endpoint/character",
                type: "POST",
                data: JSON.stringify({"name": charactername,
                                        "username": username,
                                        "money": 0,
                                        "points": 0,
                                        "map": "HomeTown",
                                        "avatar": avatar,
                                        "pokemon1name": pokemon,
                                        "pokemon2name": null,
                                        "pokemon3name": null,
                                        "object1name": null,
                                        "object2name": null,
                                        "object3name": null}),
                dataType:'json',

                success: function(data) {
                    console.log(data);
                    alert("Character loaded");
                    console.log("New Character load");
                    window.location.href = "home.html";

                },
                error: function(error){
                    message = '"error"'
                    console.log("Error",error);
                    alert("Error");
                },
            });
    });
});