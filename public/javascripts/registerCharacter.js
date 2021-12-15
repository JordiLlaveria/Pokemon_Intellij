$(document).ready(function(){
    myStorage = window.localStorage;
    $("#btnRegister2").click(function(e){
        e.preventDefault();
        var pokemon = $('#pokemons').val();
        var character = $('#character').val();
        var radioCharacter = document.getElementsByName("character"); //Check that the user choosed a character
        var radioPokemon = document.getElementsByName("pokemons"); //Check that the user choosed a pokemon

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
                //New User
                url: "/dsaApp/endpoint/character"),
                type: "POST",
                data: JSON.stringify({"character":character, "pokemon": pokemons}),
                //User user = new user(username,password,email,character);
                //data: JSON.stringify(user),
                dataType:'json',

                success: function(data) {
                    alert("Character load");
                    console.log("New Character load");
                    window.location.hred = "login.html";

                }
                error: function(error){
                    message = '"error"'
                    console.log("Error",error);
                    alert("Error");
                },
            });
        }
    });
});