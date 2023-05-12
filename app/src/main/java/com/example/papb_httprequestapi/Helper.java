package com.example.papb_httprequestapi;

public class Helper {

    public static int getIcon(int code){
        switch (code){
            case 0 : return R.drawable.img_sun;
            case 1 : return R.drawable.img_cloudy;
            case 2 : return R.drawable.img_party_cloudy;
            case 3 : return R.drawable.img_overcast;
            case 45 : return R.drawable.img_fog;
            case 48 : return R.drawable.img_fog;
            case 51 : return R.drawable.img_drizzle_slight;
            case 53 : return R.drawable.img_drizzle_moderate;
            case 55 : return R.drawable.img_drizzle_heavy;
            case 57 : return R.drawable.img_drizzle_heavy;
            case 61 :
            case 63 :
            case 65 :
            case 66 :
            case 67 : return R.drawable.img_rainy;
            case 71 : return R.drawable.img_snow;
            case 73 :
            case 75 : return R.drawable.img_snow;
            case 95 : return R.drawable.img_thunderstorm_slight;
            case 96 : return R.drawable.img_thunderstorm_moderate;
            case 99 : return R.drawable.img_thunderstorm_heavy;
            default:return R.drawable.img_sun;
        }
    }

    public static String getWeather(int code){
        switch (code){
            case 0: return "Clear Sky";
            case 1: return "Mainly Clear";
            case 2: return "Party Cloudy";
            case 3: return "Overcast";
            case 45: return "Fog";
            case 48: return "Fog";
            case 51: return "Drizzle";
            case 53: return "Drizzle";
            case 55: return "Drizzle";
            case 56: return "Freezing Drizzle";
            case 57: return "Freezing Drizzle";
            case 61: return "Rain";
            case 63: return "Rain";
            case 65: return "Rain";
            case 66: return "Freezing Rain";
            case 67: return "Freezing Rain";
            case 71: return "Snow";
            case 73: return "Snow";
            case 75: return "Snow";
            case 77: return "Snow Grains";
            case 80: return "Rain Showers";
            case 81: return "Rain Showers";
            case 82: return "Rain Showers";
            case 85: return "Snow Showers";
            case 86: return "Snow Showers";
            case 95: return "Thunderstorm";
            case 96: return "Thunderstorm";
            case 99: return "Thunderstorm";
            default: return "Clear Sky";
        }
    }
}
