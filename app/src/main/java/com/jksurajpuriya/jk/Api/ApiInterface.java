package com.jksurajpuriya.jk.Api;



import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<MyViewModel> getData();
}
