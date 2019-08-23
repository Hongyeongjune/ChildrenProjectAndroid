package com.example.user.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRetrofit {


//    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://172.16.0.131:8080/";
//
//    public static Retrofit getRetrofitInstance() {
//        if(retrofit == null) {
//            retrofit = new retrofit2.Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }

    private static final NetRetrofit ourInstance = new NetRetrofit();

    public static NetRetrofit getInstance() {
        return ourInstance;
    }

    private NetRetrofit() {
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://18.222.148.183:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitInterface netRetrofitInterface;

    public RetrofitInterface getNetRetrofitInterface(){
        if(netRetrofitInterface == null){
            netRetrofitInterface = retrofit.create(RetrofitInterface.class);
        }
        return netRetrofitInterface;
    }

}
