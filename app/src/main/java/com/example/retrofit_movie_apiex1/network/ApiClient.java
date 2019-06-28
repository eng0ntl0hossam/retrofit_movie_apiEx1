package com.example.retrofit_movie_apiex1.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BaSE_URL="";

    public static   Retrofit retrofit;


    public static Retrofit getClient(){

        if(retrofit==null)
            retrofit=new Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }


}
