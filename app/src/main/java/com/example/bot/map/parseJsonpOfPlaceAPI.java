package com.example.bot.map;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class parseJsonpOfPlaceAPI {
    MapsActivity ma;
    public List<HashMap<String,Double>> parse(JSONObject jObject){
        ma.list_location = new ArrayList<HashMap<String,Double>>();
        String tmp = "";

        List<HashMap<String,Double>> Location = new ArrayList<HashMap<String,Double>>() ;
        JSONArray jsonResults = null;
        try {
            jsonResults = jObject.getJSONArray("results");
            //Log.e("jsonresults size",String.valueOf(jsonResults.length()));
            for(int i=0;i<jsonResults.length()-1;i++){
                tmp = (String)((JSONObject)jsonResults.get(i)).getString("geometry");
                //substringは部分抜き出し、indexOfはその文字列の何番目にあるか
                //緯度
                String p_lat = tmp.substring(tmp.indexOf("lat")+5,tmp.indexOf("lng")-2);
                //経度
                String p_lng = tmp.substring(tmp.indexOf("lng")+5,tmp.indexOf("}}"));
                HashMap<String, Double> hm = new HashMap<String, Double>();
                hm.put("p_lat",Double.valueOf(p_lat));
                hm.put("p_lng",Double.valueOf(p_lng));
                Location.add(hm);
                ma.list_location.add(hm);
                }
            } catch (JSONException e) {
                e.printStackTrace();
        }catch (Exception e){
            Log.e("エラー",e.toString());
        }
     return Location;
    }
}