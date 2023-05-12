package com.example.papb_httprequestapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView city, weather, degree, windSpeed;
    ImageView imgWeather;
    RequestQueue reqQue;
    JSONObject jsonObj, jsonDay;
    WeatherAdapter wAdapter;
    RecyclerView rvWeather;
    List<Weather> dataWeather;
    String w, type, test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.tvCity);
        weather = findViewById(R.id.tvWeather);
        degree = findViewById(R.id.tvTempDegree);
        imgWeather = findViewById(R.id.imgWeather);
        windSpeed = findViewById(R.id.tvWindSpeed);
        rvWeather = findViewById(R.id.rvWeatherDay);
        dataWeather = new ArrayList<>();

        wAdapter = new WeatherAdapter( this);
        rvWeather.setHasFixedSize(true);
        rvWeather.setLayoutManager(new LinearLayoutManager(this));
        rvWeather.setAdapter(wAdapter);

        reqQue = Volley.newRequestQueue(this);
        jsonParse();
    }

    public void initData() {
        wAdapter.setData(dataWeather);
        wAdapter.notifyDataSetChanged();
    }

//    public String castWheater(int n){
//        switch (n){
//            case 0:
//                w = "Clear Sky";
//                test = "img_sun";
//                break;
//            case 1:
//                w = "Mainly Clear";
//                break;
//            case 2:
//                w = "Party Cloudy";
//                break;
//            case 3:
//                w = "Overcast";
//                break;
//            case 45:
//                w = "Fog";
//                break;
//            case 48:
//                w = "Fog";
//                break;
//            case 51:
//                w = "Drizzle";
//                break;
//            case 53:
//                w = "Drizzle";
//                break;
//            case 55:
//                w = "Drizzle";
//                break;
//            case 56:
//                w = "Freezing Drizzle";
//                type = "Light";
//                break;
//            case 57:
//                w = "Freezing Drizzle";
//                type = "Dense Intensity";
//                break;
//            case 61:
//                w = "Rain";
//                type = "Light";
//                break;
//            case 63:
//                w = "Rain";
//                type = "Moderate";
//                break;
//            case 65:
//                w = "Rain";
//                type = "Heavy Intensity";
//                break;
//            case 66:
//                w = "Freezing Rain";
//                type = "Light";
//                break;
//            case 67:
//                w = "Freezing Rain";
//                type = "Heavy Intensity";
//                break;
//            case 71:
//                w = "Snow";
//                type = "Slight";
//                break;
//            case 73:
//                w = "Snow";
//                type = "Moderate";
//                break;
//            case 75:
//                w = "Snow";
//                type = "Heavy Intensity";
//                break;
//            case 77:
//                w = "Snow Grains";
//                break;
//            case 80:
//                w = "Rain Showers";
//                type = "Slight";
//                break;
//            case 81:
//                w = "Rain Showers";
//                type = "Moderate";
//                break;
//            case 82:
//                w = "Rain Showers";
//                type = "Violent";
//                break;
//            case 85:
//                w = "Snow Showers";
//                type = "Slight";
//                break;
//            case 86:
//                w = "Snow Showers";
//                type = "Heavy";
//                break;
//            case 95:
//                w = "Thunderstorm";
//                type = "Moderate";
//                break;
//            case 96:
//                w = "Thunderstorm";
//                type = "Slight";
//                break;
//            case 99:
//                w = "Thunderstorm";
//                type = "Heavy Hail";
//                break;
//        }
//        return w;
//    }


    private void jsonParse(){
        String url = "https://api.open-meteo.com/v1/forecast?latitude=-7.98&longitude=112.63&daily=weathercode&current_weather=true&timezone=auto";
        JsonObjectRequest jsonReq =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //get data API from current weather
                    jsonObj = response.getJSONObject("current_weather");

                    Double latitude = response.getDouble("latitude");
                    Double longitude = response.getDouble("longitude");
                    String temp = jsonObj.getString("weathercode");

                    if(latitude == -8.0 && longitude == 112.625){
                        city.setText("Malang");
                    }
                    windSpeed.setText(jsonObj.getString("windspeed"));
                    degree.setText(jsonObj.getString("temperature"));
                    weather.setText(Helper.getWeather(Integer.parseInt(temp)));

                    imgWeather.setImageResource(Helper.getIcon(Integer.parseInt(temp)));

                    //get data API from daily for recycler view
                    jsonDay = response.getJSONObject("daily");
                    int t = jsonDay.getJSONArray("time").length();

                    for(int i = 0; i < t; i++){
                        String time = jsonDay.getJSONArray("time").getString(i);
                        String code = jsonDay.getJSONArray("weathercode").getString(i);
                        String weatherDesc = Helper.getWeather(Integer.parseInt(code));

                        dataWeather.add(new Weather(time, weatherDesc, code));
                    }
                    initData();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        reqQue.add(jsonReq);
    }
}