package services;

import java.util.List;

import models.AchvExt;
import models.QuestExt;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuestRepo {
    @GET("quest/user/{id}")
    Call<List<QuestExt>> getQuests(@Path("id") int id);
}
