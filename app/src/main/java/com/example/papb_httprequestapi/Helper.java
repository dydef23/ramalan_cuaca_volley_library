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
            case 61 : return R.drawable.img_rainy;
            case 63 : return R.drawable.img_rainy;
            case 65 : return R.drawable.img_rainy;
            case 66 : return R.drawable.img_rainy;
            case 67 : return R.drawable.img_rainy;
            case 71 : return R.drawable.img_snow;
            case 73 : return R.drawable.img_snow;
            case 75 : return R.drawable.img_snow;
            case 95 : return R.drawable.img_thunderstorm_slight;
            case 96 : return R.drawable.img_thunderstorm_moderate;
            case 99 : return R.drawable.img_thunderstorm_heavy;
            default:return R.drawable.img_sun;
        }
    }
}
