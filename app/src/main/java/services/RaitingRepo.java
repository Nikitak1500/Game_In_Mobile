package services;

import java.util.List;

import models.Place;
import models.Raiting;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RaitingRepo {
    @GET("raiting")
    Call<List<Raiting>> getRaitings();

    @GET("raiting/{id}")
    Call<Raiting> getRaiting(@Path("id") int id);

    @GET("raiting/{id}/places")
    Call<List<Place>> getPlaces(@Path("id") int id);
}
