package com.edu.eci.arsw.parcial2.controllers;

import com.edu.eci.arsw.parcial2.services.OpenWeatherMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "/weather")
@CrossOrigin(origins = "*")
public class WeatherAPIController {

    @Autowired
    OpenWeatherMapService owms;

    /**
     * 
     * @param city The city to which the climate is going to be consulted.
     * @return The information of the weather.
     */
    @RequestMapping(method = RequestMethod.GET,path = "/{city}")
    public ResponseEntity<?> handlerGetResourceWeather(@PathVariable String city) {
        try {
            return new ResponseEntity<>(owms.getInfo(city), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(WeatherAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error, city not found", HttpStatus.NOT_FOUND);
        }
    }

}
