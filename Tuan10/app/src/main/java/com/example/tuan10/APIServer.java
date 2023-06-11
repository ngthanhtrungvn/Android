package com.example.tuan10;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServer {
    @GET("/hello")
    Call<User> hello();
}
