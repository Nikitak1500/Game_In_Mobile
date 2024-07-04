package facedes;

import java.util.List;

import models.AchvExt;
import models.AuthRequest;
import models.AuthResp;
import models.Level;
import models.Place;
import models.QuestExt;
import models.Raiting;
import models.Reward;
import models.Title;
import models.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.AchievementRepo;
import services.LevelRepo;
import services.QuestRepo;
import services.RaitingRepo;
import services.RewardRepo;
import services.UserRepo;


public class RetrofitFacade {

    private static Retrofit retrofit;
    private static UserRepo userRepo;
    private static LevelRepo levelRepo;
    private static RewardRepo rewardRepo;
    private static AchievementRepo achievementRepo;
    private static RaitingRepo raitingRepo;
    private static QuestRepo questRepo;

    private static void start(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static void userApi(){
        start();
        userRepo = retrofit.create(UserRepo.class);
    }

    private static void questApi(){
        start();
        questRepo = retrofit.create(QuestRepo.class);
    }

    private static void levelApi(){
        start();
        levelRepo = retrofit.create(LevelRepo.class);
    }

    private static void rewardApi(){
        start();
        rewardRepo = retrofit.create(RewardRepo.class);
    }

    private static void achvApi(){
        start();
        achievementRepo = retrofit.create(AchievementRepo.class);
    }

    private static void raitingApi(){
        start();
        raitingRepo = retrofit.create(RaitingRepo.class);
    }

    public static Call<List<Raiting>> getRaitings(){
        raitingApi();

        Call<List<Raiting>> call = raitingRepo.getRaitings();

        return call;
    }

    public static Call<Raiting> getRaiting(int id){
        raitingApi();

        Call<Raiting> call = raitingRepo.getRaiting(id);

        return call;
    }

    public static Call<List<Place>> getPlaces(int id){
        raitingApi();

        Call<List<Place>> call = raitingRepo.getPlaces(id);

        return call;
    }

    public static Call<List<AchvExt>> getAchvs(int id){
        achvApi();

        Call<List<AchvExt>> call = achievementRepo.getAchv(id);

        return call;
    }

    public static Call<List<Reward>> getRewards(){
        rewardApi();

        Call<List<Reward>> call = rewardRepo.getRewards();

        return call;
    }

    public static Call<String> buyReward(int id, int uid){
        rewardApi();

        Call<String> call = rewardRepo.buyReward(id, uid);

        return call;
    }

    public static Call<Level> userLvl(int exp){
        levelApi();

        Call<Level> call = levelRepo.getUserLvl(exp);

        return call;
    }

    public static Call<AuthResp> auth(String login, String pass){
        userApi();
        AuthRequest authRequest = new AuthRequest();
        authRequest.setLogin(login);
        authRequest.setPass(pass);

        Call<AuthResp> call = userRepo.auth(authRequest);

        return call;
    }

    public static Call<User> accInfo(int id){
        userApi();

        Call<User> call = userRepo.getUser(id);

        return call;
    }

    public static Call<List<Title>> getTitles(int id){
        userApi();

        Call<List<Title>> call = userRepo.getUserTiles(id);

        return call;
    }

    public static Call<List<QuestExt>> getQuests(int id){
        questApi();

        Call<List<QuestExt>> call = questRepo.getQuests(id);

        return call;
    }
}
