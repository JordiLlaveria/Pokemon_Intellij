$(document).ready(function(){
    $("#pokedexBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/pokedex.html");
    })
    $("#mapsBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/maps.html");
    })
    $("#rankingBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/ranking.html");
    })
    $("#editBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/editprofile.html");
    })

    $("#closeBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/home.html");
    })
    $("#deleteBt").click(function(){
        var username = localStorage.getItem("username");
        $.ajax({
            url: "http://localhost:8080/dsaApp/endpoint/delete/"+username,
            type: "PUT",
            data: { get_param: 'value' },
            dataType:'json',
            success: function(data) {
                alert("User deleted");
                window.location.href = "index.html";
            },
            error: function( xhr, textStatus, errorThrown) {
                alert("Error.");
            }
            });
    })
});