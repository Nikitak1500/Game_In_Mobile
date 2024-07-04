package services;

import java.util.List;

import models.AuthRequest;
import models.AuthResp;
import models.Title;
import models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserRepo {
    @GET("user/{id}")
    Call<User> getUser(@Path("id") int id);

    @GET("user/{id}/titles")
    Call<List<Title>> getUserTiles(@Path("id") int id);

    @POST("user/auth")
    Call<AuthResp> auth(@Body AuthRequest requestBody);

    @POST("user/register")
    Call<String> register(@Body AuthRequest requestBody);
}
