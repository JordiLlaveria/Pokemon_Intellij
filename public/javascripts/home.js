$(document).ready(function(){
    var charactername = localStorage.getItem("charactername");

    $("#optionsBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/options.html");
    })
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/dsaApp/endpoint/character/"+charactername,
        data: { get_param: 'value' },
        dataType: 'json',
        success: function (data) {
            $("#avatar").attr("src","../pictures/"+data.avatar.toLowerCase()+".png");
            $("#charactername").text(data.name);
            if(data.pokemon1name != null){
                $("#pokemon1img").attr("src","../pictures/"+data.pokemon1name.toLowerCase()+".png");
                $("#pokemon1").text(data.pokemon1name);
            }
            else{
                $("#pokemon1img").hide();
                $("#pokemon1").hide();
            }
            if(data.pokemon2name != null){
                $("#pokemon2img").attr("src","../pictures/"+data.pokemon2name.toLowerCase()+".png");
                $("#pokemon2").text(data.pokemon2name);
            }
            else{
                $("#pokemon2img").hide();
                $("#pokemon2").hide();
            }
            if(data.pokemon3name != null){
                $("#pokemon3img").attr("src","../pictures/"+data.pokemon3name.toLowerCase()+".png");
                $("#pokemon3").text(data.pokemon3name);
            }
            else{
                 $("#pokemon3img").hide();
                 $("#pokemon3").hide();
            }
            $("#points").text("Points: "+data.points.toString());
            $("#money").text("Money: "+data.money.toString());
            $("#location").text("Level: " + data.map);
            if(data.object1name != null){
                $("#object1img").attr("src","../pictures/"+data.object1name.toLowerCase()+".png");
                $("#object1").text(data.object1name);
            }
            else{
                $("#object1img").hide();
                $("#object1").hide();
            }
            if(data.object2name != null){
                $("#object2img").attr("src","../pictures/"+data.object2name.toLowerCase()+".png");
                $("#object2").text(data.object2name);
            }
            else{
                $("#object2img").hide();
                $("#object2").hide();
            }
            if(data.object3name != null){
                $("#object3img").attr("src","../pictures/"+data.object3name.toLowerCase()+".png");
                $("#object3").text(data.object2name);
            }
            else{
                $("#object3img").hide();
                $("#object3").hide();
            }
        }
    });

});