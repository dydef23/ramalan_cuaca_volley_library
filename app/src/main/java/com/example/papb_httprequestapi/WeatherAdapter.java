package com.example.papb_httprequestapi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {

    Context ctx;
    List<Weather> data;

    public WeatherAdapter (Context context, List<Weather> data){
        this.ctx = context;
        this.data = data;
    }

    public WeatherAdapter (Context context){
        this.ctx = context;
        this.data = new ArrayList<>();
    }

    class VHWeather extends RecyclerView.ViewHolder  {

        TextView day, temp, weather;

        public VHWeather(@NonNull View itemView) {
            super(itemView);
            this.day = itemView.findViewById(R.id.tvDay);
            this.weather = itemView.findViewById(R.id.tvDayWeather);
        }
    }

    public void setData(List<Weather> data) {
        this.data = data;
    }

    public List<Weather> getData() {
        return data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.ctx).inflate(R.layout.daily_row, parent, false);
        return new VHWeather(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VHWeather vh = (VHWeather) holder;
        Weather w = this.data.get(position);

//        Format f = new SimpleDateFormat("EEEE");
//        String getDay = f.format(w.day);
//        Log.i("Hari", getDay);

        vh.weather.setText(w.weather);
        vh.day.setText(w.day);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
