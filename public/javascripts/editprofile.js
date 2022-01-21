
$(document).ready(function(){
    $("#closeBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/options.html");
    })
    $("#btnOK").click(function(e){
        e.preventDefault();
        var email = $('#email').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        var charactername = localStorage.getItem("charactername");
        var username = localStorage.getItem("username");

        if (password != password2){ //Check if the passwords match
            alert("Password doesn't match")
        }
        else if (password == null || password2 == null || email == null) {//Check that there's no empty spaces
            alert("Please fill all the spaces")
        }
        else {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                //New User
                url: "http://localhost:8080/dsaApp/endpoint/updateuser",
                type: "PUT",
                data: JSON.stringify({"name":username, "password": password, "email":email, "charactername": charactername}),
                dataType:'json',

                success: function(data) {
                    alert("User updated");
                    window.location.href = "options.html";

                },
                error: function( xhr, textStatus, errorThrown) {
                    alert("Error.");
                }
            });
        }
    });
});