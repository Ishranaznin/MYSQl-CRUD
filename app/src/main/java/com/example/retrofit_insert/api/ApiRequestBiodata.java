package com.example.retrofit_insert.api;
import com.example.retrofit_insert.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiRequestBiodata {

        @FormUrlEncoded
        @POST("insert.php")
        Call<ResponsModel> sendBiodata(@Field("name") String name, @Field("salary") String salary, @Field("designation") String designation);



}
