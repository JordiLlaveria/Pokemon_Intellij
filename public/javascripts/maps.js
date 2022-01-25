$(document).ready(function(){
    $("#closeBt").click(function(){
        let url = window.location.origin;
        window.location.replace(url+"/html/options.html");
    })
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dsaApp/endpoint/maps',
        data: { get_param: 'value' },
        dataType: 'json',
        success: function (data) {
            $.each(data, function(index, element) {
                var newDiv = document.createElement('div');
                var newContent = document.createTextNode(element.name);
                newDiv.appendChild(newContent);
                document.getElementById("maps").appendChild(newDiv);

                var elem = document.createElement("img");
                elem.setAttribute("src", "../pictures/charmander.png");
                elem.setAttribute("height", "768");
                elem.setAttribute("width", "1024");
                var newDiv2 = document.createElement('div');
                newDiv.appendChild(elem);
                document.getElementById("maps").appendChild(newDiv2);
            });
        }
    });
});