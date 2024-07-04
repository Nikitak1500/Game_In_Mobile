package services;

import models.Level;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LevelRepo {
    @GET("level/user")
    Call<Level> getUserLvl(@Query("exp") int exp);
}
