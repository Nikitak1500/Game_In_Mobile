package services;

import java.util.List;

import models.AchvExt;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AchievementRepo {
    @GET("achievement/user/{id}")
    Call<List<AchvExt>> getAchv(@Path("id") int id);
}
