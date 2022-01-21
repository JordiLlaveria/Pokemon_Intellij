$(document).ready(function(){
    $("#closeBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/options.html");
    })
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dsaApp/endpoint/pokemons',
        data: { get_param: 'value' },
        dataType: 'json',
        success: function (data) {
            $.each(data, function(index, element) {
                $("#name").append($('<div>', {
                    text: element.name
                }));
                $("#type").append($('<div>', {
                    text: element.type
                }));
                $("#health").append($('<div>', {
                    text: element.maxhealth
                }));

            });
        }
    });
});