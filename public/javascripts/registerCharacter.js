$(document).ready(function(){
    myStorage = window.localStorage;
    $("#btnRegister").click(function(e){
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
    });
});