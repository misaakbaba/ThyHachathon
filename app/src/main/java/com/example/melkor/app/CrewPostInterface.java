package com.example.melkor.app;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CrewPostInterface {
    @POST("login")
    @FormUrlEncoded
    Call<Crew> checkCrew(
            @Field("mail") String mail,
            @Field("password") String password);
}


