var instance = axios.create({
  baseURL: 'https://arsw-parcial2.herokuapp.com/weather/'
//  headers: {'Access-Control-Allow-Origin': '*'}
});

var WeatherAPI = (function() {

    var getInfo = function() {
        var main = document.getElementsByTagName("main")[0];
        var input = document.getElementById("input");
        instance.get(input.value)
                .then(function (response) {
                    var weather = document.createElement("p");
                    var weatherText = document.createTextNode("Weather: " + response.data.weather[0].description);
                    weather.appendChild(weatherText);
                    main.appendChild(weather);
                    var humidity = document.createElement("p");
                    var humidityText = document.createTextNode("Humidity: " + response.data.main.humidity);
                    humidity.appendChild(humidityText);
                    main.appendChild(humidity);
                    var minTemp = document.createElement("p");
                    var minTempText = document.createTextNode("Minimum Temperature: " + response.data.main.temp_min);
                    minTemp.appendChild(minTempText);
                    main.appendChild(minTemp);
                    var maxTemp = document.createElement("p");
                    var maxTempText = document.createTextNode("Maximum Temperature: " + response.data.main.temp_max);
                    maxTemp.appendChild(maxTempText);
                    main.appendChild(maxTemp);
                    var speedWind = document.createElement("p");
                    var speedWindText = document.createTextNode("Minimum Temperature: " + response.data.wind.speed);
                    speedWind.appendChild(speedWindText);
                    main.appendChild(speedWind);
                    
                    console.log(response);
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                });
    };

    return {
        getInfo:getInfo
    };

})();