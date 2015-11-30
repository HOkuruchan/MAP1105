package com.example.bot.map;
//Jdbcでサーバ接続
import android.os.AsyncTask;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AsyncJob extends AsyncTask<String,String,String>  {

    private MapsActivity _main;

    public AsyncJob(MapsActivity main) {
        super();
        _main = main;
    }
    @Override
    protected String doInBackground(String...value) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            //接続
            //String url = "jdbc:mariadb://mirai2015kuru.ddns.net:3306/hosei_test";
            //Connection con = DriverManager.getConnection(url, "hoseitest", "hoseitest");
            String url = "jdbc:mariadb://10.29.31.139:3306/test";
            Connection con = DriverManager.getConnection(url, "hosei", "hosei");
            Statement stmt = con.createStatement();

            // テーブル作成
            stmt.execute("CREATE TABLE IF NOT EXISTS test (S_lat double,S_lon double," +   //出発地点の緯度経度
                                                            "D_lat double,D_lon double," +  //目的地点の緯度経度
                                                            "S_cost int,N_cost int)");      //段差コストと通常コスト
            //　データ挿入
            stmt.execute("INSERT INTO test (S_lat,S_lon," +
                                            "D_lat,D_lon," +
                                            "S_cost,N_cost) " +
                                            "values ( 1.0 , 2.0 , 3.0 , 4.0 , 1 , 0 )");

            //　データベースにクエリ送信
            ResultSet rs = stmt.executeQuery("SELECT * FROM test");

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
            }
            rs.close();
            stmt.close();

            con.commit();
            con.close();
        } catch (Exception e) {
            Log.e("ServerProcessエラー", e.toString());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {}

    @Override
    protected void onPostExecute(String result) {
        //_main.result_job(result);
    }
}
