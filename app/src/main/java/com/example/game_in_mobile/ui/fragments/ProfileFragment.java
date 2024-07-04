package com.example.game_in_mobile.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.game_in_mobile.R;

import java.util.List;

import facedes.RetrofitFacade;
import models.Level;
import models.Title;
import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private static final String UID_ARG = "uid";

    private int uid;

    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance(int uid) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(UID_ARG, uid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uid = getArguments().getInt(UID_ARG);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        RetrofitFacade.accInfo(uid).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                printAccInfo(response.body(), v);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


        return v;
    }

    private void printAccInfo(User user, View v){
        TextView uName = v.findViewById(R.id.textView5);
        uName.setText(user.getUserName());

        TextView email = v.findViewById(R.id.textView6);
        email.setText("Email: " + user.getEmail());

        TextView bonus = v.findViewById(R.id.textView7);
        bonus.setText( user.getUserBonuses() + " bonuses");

        RetrofitFacade.userLvl(user.getExperience()).enqueue(new Callback<Level>() {
            @Override
            public void onResponse(Call<Level> call, Response<Level> response) {
                printLevel(response.body(), v, user);
            }

            @Override
            public void onFailure(Call<Level> call, Throwable t) {

            }
        });

        RetrofitFacade.getTitles(uid).enqueue(new Callback<List<Title>>() {
            @Override
            public void onResponse(Call<List<Title>> call, Response<List<Title>> response) {
                printTitles(response.body(), v);
            }

            @Override
            public void onFailure(Call<List<Title>> call, Throwable t) {

            }
        });
    }

    private void printLevel(Level level, View v, User user){
        TextView lev = v.findViewById(R.id.textView8);
        lev.setText("Level: " + level.getLevelName());

        ProgressBar progressBar = v.findViewById(R.id.progressBar);
        progressBar.setMax(level.getExpAmount());
        progressBar.setProgress(user.getExperience());
    }

    private void printTitles(List<Title> titles, View v){
        TextView t = v.findViewById(R.id.textView10);
        String s = "";
        for (Title title : titles
             ) {
            s += "- " + title.getTitleName() + " -\n";
        }

        t.setText(s);
    }
}