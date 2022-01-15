$(document).ready(function(){
    $("#pokedexBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/pokedex.html");
    })
    $("#mapsBt").click(function(){
        //let url = window.location.origin;
        //window.location.replace(url+"/html/pokedex.html");
    })
    $("#rankingBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/ranking.html");
    })
    $("#editBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/editprofile.html");
    })
    $("#deleteBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/deleteprofile.html");
    })
    $("#closeBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/index.html");
    })
});