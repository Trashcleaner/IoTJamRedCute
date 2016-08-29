package com.redcute;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by obrusvit on 29.8.16.
 */
public class Input {

    private String token = "7TOEYELOrQpsJRhVQLRtnCaheigkWmX2";
    Gson gson = new Gson();

    public void execute(){
        String url = "https://api.pripoj.me/project/get/?token=7TOEYELOrQpsJRhVQLRtnCaheigkWmX2";
        try{
            sendGet(url);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
