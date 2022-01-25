$(document).ready(function(){
    $("#closeBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/options.html");
    })
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dsaApp/endpoint/ranking',
        data: { get_param: 'value' },
        dataType: 'json',
        success: function (data) {
            for (let i = 0; i < 10; i++){
                $("#name").append($('<div>', {
                    text: data[i].name
                }));
                $("#points").append($('<div>', {
                    text: data[i].points
                }));
                $("#pokemon").append($('<div>', {
                    text: data[i].pokemon1name
                }));
            }
        }
    });
});