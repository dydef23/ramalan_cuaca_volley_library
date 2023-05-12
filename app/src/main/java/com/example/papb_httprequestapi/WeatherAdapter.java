package com.example.papb_httprequestapi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {

    Context ctx;
    List<Weather> data;

    public WeatherAdapter (Context context){
        this.ctx = context;
        this.data = new ArrayList<>();
    }

    class VHWeather extends RecyclerView.ViewHolder  {

        TextView day, weather;
        ImageView weatherImg;

        public VHWeather(@NonNull View itemView) {
            super(itemView);
            this.day = itemView.findViewById(R.id.tvDay);
            this.weather = itemView.findViewById(R.id.tvDayWeather);
            this.weatherImg = itemView.findViewById(R.id.imgDayWeather);
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

        LocalDate date = LocalDate.parse(w.date);

        if(vh.getAdapterPosition() == 0){
            vh.day.setText("Today");
        } else if (vh.getAdapterPosition() == 1) {
            vh.day.setText("Tomorrow");
        } else{
            String temp = String.valueOf(date.getDayOfWeek());
            vh.day.setText(String.valueOf(dayFormat(temp)));
        }
        vh.weatherImg.setImageResource(Helper.getIcon(Integer.parseInt(w.code)));
        vh.weather.setText(w.weather);
    }

    public String dayFormat(String n){
        String temp = n.substring(0,1) + n.substring(1).toLowerCase();
        return temp;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
