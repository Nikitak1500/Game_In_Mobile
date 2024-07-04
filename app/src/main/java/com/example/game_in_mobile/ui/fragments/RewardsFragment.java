package com.example.game_in_mobile.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.game_in_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import facedes.RetrofitFacade;
import models.Reward;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RewardsFragment extends Fragment {

    private static final String ARG_ROLE = "role";
    private static final String ARG_UID = "uid";

    private String role;
    private int uid;

    public RewardsFragment() {
        // Required empty public constructor
    }


    public static RewardsFragment newInstance(String role, int uid) {
        RewardsFragment fragment = new RewardsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ROLE, role);
        args.putInt(ARG_UID, uid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            role = getArguments().getString(ARG_ROLE);
            uid = getArguments().getInt(ARG_UID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rewards, container, false);

        RetrofitFacade.getRewards().enqueue(new Callback<List<Reward>>() {
            @Override
            public void onResponse(Call<List<Reward>> call, Response<List<Reward>> response) {
                drawList(v, response.body());
            }

            @Override
            public void onFailure(Call<List<Reward>> call, Throwable t) {

            }
        });



        return v;
    }

    private void drawList(View v, List<Reward> list){
        LinearLayout scroll = v.findViewById(R.id.rewardContainer);

        for (Reward one : list
             ) {
            scroll.addView(fillOne(one));
        }
    }

    private LinearLayout fillOne(Reward one){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        LinearLayout block = new LinearLayout(getActivity().getApplicationContext());
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams((int) (width * 0.92), (int) (height * 0.79));
        layoutParams.setMargins(0,0,15,0);
        block.setPadding(10,10,10,10);
        block.setBackgroundColor(getResources().getColor(R.color.card));
        block.setOrientation(LinearLayout.VERTICAL);
        block.setGravity(Gravity.CENTER);
        block.setLayoutParams(layoutParams);

        ImageView img = new ImageView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsImg =
                new LinearLayout.LayoutParams((int) (width * 0.5), (int) (width * 0.5));
        paramsImg.setMargins(0,0,0,20);
        img.setLayoutParams(paramsImg);
        Picasso.with(getActivity())
                .load(R.drawable.reward)
                .into(img);

        TextView valueText = new TextView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsText =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        paramsText.setMargins(0,0,0,20);
        valueText.setLayoutParams(paramsText);
        valueText.setTextSize(24);
        valueText.setText(one.getRewardValue());

        Button btn = new Button(getActivity().getApplicationContext());
        btn.setText(getString(R.string.buy));
        btn.setTextSize(32);
        btn.setOnClickListener(v -> RetrofitFacade.buyReward(
                one.getIdreward(), uid).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body().equals("OK")) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            getString(R.string.buy_success), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            getString(R.string.buy_erorr), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),
                        getString(R.string.buy_erorr), Toast.LENGTH_SHORT).show();
            }
        }));
        btn.setLayoutParams(paramsText);

        block.addView(img);
        block.addView(valueText);
        block.addView(btn);

        return block;
    }
}