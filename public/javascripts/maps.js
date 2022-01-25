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
                newDiv.setAttribute("class","row");
                var newContent = document.createTextNode(element.name);
                newDiv.appendChild(newContent);
                document.getElementById("maps").appendChild(newDiv);

                var elem = document.createElement("img");
                elem.setAttribute("src", "../pictures/"+element.name+".jpeg");
                elem.setAttribute("width","300px");
                elem.setAttribute("height","200px");
                var newDiv2 = document.createElement('div');
                newDiv2.setAttribute("class","row");
                newDiv2.appendChild(elem);
                document.getElementById("maps").appendChild(newDiv2);
            });
        }
    });
});