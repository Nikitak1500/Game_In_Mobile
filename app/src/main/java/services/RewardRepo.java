package services;

import java.util.List;

import models.Reward;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RewardRepo {
    @GET("reward")
    Call<List<Reward>> getRewards();

    @GET("reward/{id}")
    Call<Reward> getReward(@Path("id") int id);

    @POST("reward")
    Call<Reward> addReward(@Body Reward reward);

    @PUT("reward/{id}")
    Call<Reward> editReward(@Body Reward reward, @Path("id") int id);

    @DELETE("reward/{id}")
    Call<Void> delReward(@Path("id") int id);

    @GET("reward/buy/{id}")
    Call<String> buyReward(@Path("id") int id, @Query("userId") int uid);
}
