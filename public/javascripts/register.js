var BASE_URI = "http://localhost:8080/dsaApp"
$(document).ready(function(){
    myStorage = window.localStorage;
    $("#btnRegister").click(function(e){
        e.preventDefault();
        var username = $('#username').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        var email = $('#email').val();
        var character = $('#character').val();
        var pokemon = $('#pokemons').val();

        if (password != password2){ //Check if the passwords match
            alert("Password doesn't match")
        }
        else if (username == null || password == null || password2 == null || email == null) {//Check that there's no empty spaces
            alert("Please fill all the spaces")

        }
        var radioCharacter = document.getElementsByName("character"); //Check that the user choosed a character
        if(!(radioCharacter[0].checked || radioCharacter[1].checked || radioCharacter[2].checked)) {
            alert("Please select your favorite character")
        }
        var radioPokemon = document.getElementsByName("pokemons"); //Check that the user choosed a pokemon
        if(!(radioPokemon[0].checked || radioPokemon[1].checked || radioPokemon[2].checked)) {
            alert("Please select your favorite pokemon")
       }
       else {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: BASE_URI.concat("/auth/user"),
                type: "POST",
                data: JSON.stringify({"username": username, "password": password, "email":email, "character":character}),
                dataType:'json',

                success: function(data) {
                alert("Welcome to Pokemon world");
                console.log("Registered");
                window.location.hred = "login.html";
                }
                error: function(error){
                message = '"error"'
                console.log("Error",error);
                alert("Error");
                },
            });
            }
       }
       }
       }
    }