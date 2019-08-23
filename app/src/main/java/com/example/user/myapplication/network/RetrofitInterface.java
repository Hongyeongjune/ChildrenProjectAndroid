package com.example.user.myapplication.network;

import com.example.user.myapplication.model.dto.CIDto;
import com.example.user.myapplication.model.dto.NHDto;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {

//    @POST("create")
//    Call<Void> createUser(@Body UserNHDto userNHDto);
//
//    @POST("createCI")
//    Call<Void> createUserCI(@Body UserCIDto userCIDto);

//    @POST("create")
//    Call<UserNH> createUser(@Body UserNH userNH);

    @POST("createNH")
    Call<Void> createNHMusic(@Body NHDto NHDto);

    @POST("createCI")
    Call<Void> createCIMusic(@Body CIDto CIDto);

    @GET("createNHFile/{name}")
    Call<Void> createNHFile(@Path("name") String name);

    @GET("createCIFile/{name}")
    Call<Void> createCIFile(@Path("name") String name);

    @GET("downloads/filename/{filename}")
    Call<ResponseBody> downloadFileByFileName(@Path("filename") String fileName);
//    @POST("createVoiceNH")
//    Call<Void> createNHVoice(@Body VoiceNHDto voiceNHDto);
//
//    @POST("createVoiceCI")
//    Call<Void> createCIVoice(@Body VoiceCIDto voiceCIDto);

}
