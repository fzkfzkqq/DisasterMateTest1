package com.example.myapplication;

import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Restful {
    private static final String BASE_URL =
            "https://disastermateapi.azurewebsites.net/test.json?postcode=";

    public static String findByPostcode(String postcode) {
        //final String methodPath = "entities.food/";
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
//Making HTTP request
        try {
            url = new URL(BASE_URL + postcode);
//open the connection
            conn = (HttpURLConnection) url.openConnection();
//set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
//set the connection method to GET
            conn.setRequestMethod("GET");
//add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
//Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
//read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
            Log.i(" JSON ", textResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
}
