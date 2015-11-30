//package com.example.bot.map;
//
//import android.os.Bundle;
//import org.json.JSONObject;
//import java.lang.reflect.Method;
//
//public class Volly_ServerCommunication {
//    private RequestQueue mQueue;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // 東京都の天気情報
//        String url =
//                "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010";
//
//        mQueue = Volley.newRequestQueue(this);
//        mQueue.add(new JsonObjectRequest(Method.GET, url, null,
//                new Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // JSONObjectのパース、List、Viewへの追加等
//                    }
//                },
//
//                new Response.ErrorListener() {
//                    @Override public void onErrorResponse(VolleyError error) {
//                        // エラー処理 error.networkResponseで確認
//                        // エラー表示など
//                    }
//                }));
//}
