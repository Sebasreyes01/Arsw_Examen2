package com.edu.eci.arsw.parcial2.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

@Service
public class OpenWeatherMapService {

    private static final String USER_AGENT = "Mozilla/5.0";
//    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";
//    http://api.openweathermap.org/data/2.5/weather?q=Bogota,CO&appid=1e7e8de23dd81f89d9138bb3dd802856
    private static final String SITE = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String ID = "&appid=1e7e8de23dd81f89d9138bb3dd802856";

    /**
     * 
     * @param city the city to which the climate is going to be consulted.
     * @return The information of the weather.
     * @throws IOException 
     */
    public String getInfo(String city) throws IOException {

        URL obj = new URL(SITE+city+ID);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
            throw new NoSuchElementException("City not found");
        }
//        System.out.println("GET DONE");
    }

}
