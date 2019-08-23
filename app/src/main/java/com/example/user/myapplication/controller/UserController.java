package com.example.user.myapplication.controller;

import android.content.Context;

import com.example.user.myapplication.model.dto.CIDto;
import com.example.user.myapplication.model.dto.NHDto;
import com.example.user.myapplication.network.NetRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserController {

    Context context;

    public UserController(Context context) {
        this.context = context;
    }

    public void signupNH(NHDto NHDto) {
        Call<Void> call = NetRetrofit.getInstance().getNetRetrofitInterface().createNHMusic(NHDto);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    public void signupCI(CIDto CIDto) {
        Call<Void> call = NetRetrofit.getInstance().getNetRetrofitInterface().createCIMusic(CIDto);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


}
