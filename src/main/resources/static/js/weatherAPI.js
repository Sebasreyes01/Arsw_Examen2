var instance = axios.create({
  baseURL: 'https://arsw-parcial2.herokuapp.com/weather/'
//  headers: {'Access-Control-Allow-Origin': '*'}
});

var WeatherAPI = (function() {

    var getInfo = function() {
        var main = document.getElementsByTagName("main")[0];
        var input = document.getElementById("input");
        console.log(input.value);
        instance.get(input.value)
                .then(function (response) {
                    var info = document.createElement("p");
                    var infoText = document.createTextNode(response);
                    info.appendChild(infoText);
                    main.appendChild(info);
                    console.log(response);
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                });
        
//        var info = document.createElement("p");
//        var infoText = document.createTextNode(input.value);
//        info.appendChild(infoText);
//        main.appendChild(info);
    };

    return {
        getInfo:getInfo
    };

})();