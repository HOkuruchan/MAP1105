package com.example.bot.map;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

//Jsonをリスト化して、別クラスに飛ばす
public class PlaceParserTask extends AsyncTask<String,Void,List<HashMap<String,Double>> > {
    @Override
    protected List<HashMap<String, Double>> doInBackground(String... jsonData) {

        JSONObject jObject;
        List<HashMap<String, Double>> p_Location = null;

        try {
            jObject = new JSONObject(jsonData[0]);
            parseJsonpOfPlaceAPI parser = new parseJsonpOfPlaceAPI();

            p_Location = parser.parse(jObject);
            //Log.e("",String.valueOf(p_Location.size()));
        } catch (Exception e) {

            Log.d("error2", "??????????????????????????????????");
            e.printStackTrace();
        }
        return p_Location;
    }


    @Override
    protected void onPostExecute(List<HashMap<String,Double>> result) {
        super.onPostExecute(result);
        // プログレス終了処理
    }
}
