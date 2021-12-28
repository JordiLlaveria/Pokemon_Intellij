$(document).ready(function(){
    //myStorage = window.localStorage;
    $("#btnRegister2").click(function(e){
        e.preventDefault();
        var pokemon = $('#pokemon').val();
        var avatar = $('#character').val();
        var radioCharacter = document.getElementsByName("character").value; //Check that the user chose a character
        var radioPokemon = document.getElementsByName("pokemon").value; //Check that the user chose a pokemon

        var username = localStorage.getItem("username");
        var charactername = localStorage.getItem("charactername");

        if(!(radioCharacter[0].checked || radioCharacter[1].checked || radioCharacter[2].checked)) {
                alert("Please select your favorite character")
        }
        else if(!(radioPokemon[0].checked || radioPokemon[1].checked || radioPokemon[2].checked)) {
            alert("Please select your favorite pokemon")
        } //Falta la funció perque faci la peticio

        else {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "http://localhost:8080/dsaApp/endpoint/character",
                type: "POST",
                data: JSON.stringify({"name": charactername,
                                        "username": username,
                                        "money": 0,
                                        "points": 0,
                                        "map": "level1",
                                        "avatar": avatar,
                                        "pokemon1name": pokemon,
                                        "pokemon2name": null,
                                        "pokemon3name": null,
                                        "object1name": null,
                                        "object2name": null,
                                        "object3name": null}),
                //User user = new user(username,password,email,character);
                //data: JSON.stringify(user),
                dataType:'json',

                success: function(data) {
                    alert("Character loaded");
                    console.log("New Character load");
                    //myStorage.setItem("character",data.character);
                    //myStorage.setItem("pokemon",data.pokemon);
                    window.location.hred = "home.html";

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