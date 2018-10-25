var WeatherAPI = (function() {

    var getInfo = function() {
        var main = document.getElementsByTagName("main")[0];
        var input = document.getElementById("input");

        var info = document.createElement("p");
        var infoText = document.createTextNode(input.value);
        info.appendChild(infoText);
        main.appendChild(info);
    };

    return {
        getInfo:getInfo
    };

})();