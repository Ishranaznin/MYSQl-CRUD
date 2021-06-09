package com.example.retrofit_insert.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retroserver {
    // private  static  final String base_url = "http://192.168.56.1/android/retrofit_rnd/retrofit_EMS_CRUD/";
    private  static  final String base_url = "http://10.0.2.2/retrofit/";



    private static Retrofit retrofit;


    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
