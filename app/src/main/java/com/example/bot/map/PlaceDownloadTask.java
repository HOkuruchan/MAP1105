package com.example.bot.map;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.location.places.Place;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class PlaceDownloadTask extends AsyncTask<String, Void, String> {
    //非同期で取得
    protected String doInBackground(String... url) {
        String place_data = "";
        try{
            // Fetching the data from web service
            place_data = PlacedownloadUrl(url[0]);
        }catch(Exception e){
            Log.d("Background Task", e.toString());
        }
        return place_data;
    }
    // doInBackground()
    @Override
    protected void onPostExecute(String result) {
        PlaceParserTask placeparserTask = new PlaceParserTask();
        placeparserTask.execute(result);
    }

    //httpからJsonデータにセットしてdataに入れて返す
    private String PlacedownloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }
            data = sb.toString();

            br.close();
        }catch(Exception e){
            Log.e("Placedownloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}

