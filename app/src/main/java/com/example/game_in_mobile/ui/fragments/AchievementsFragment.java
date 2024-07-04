package com.example.game_in_mobile.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.game_in_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import facedes.RetrofitFacade;
import models.AchvExt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AchievementsFragment extends Fragment {

    private static final String ARG_UID = "uid";
    private static final String ARG_ROLE = "role";

    private int uid;
    private String role;

    public AchievementsFragment() {
        // Required empty public constructor
    }

    public static AchievementsFragment newInstance(int uid, String role) {
        AchievementsFragment fragment = new AchievementsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_UID, uid);
        args.putString(ARG_ROLE, role);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uid = getArguments().getInt(ARG_UID);
            role = getArguments().getString(ARG_ROLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_achievements, container, false);

        RetrofitFacade.getAchvs(uid).enqueue(new Callback<List<AchvExt>>() {
            @Override
            public void onResponse(Call<List<AchvExt>> call, Response<List<AchvExt>> response) {
                drawList(v, response.body());
            }

            @Override
            public void onFailure(Call<List<AchvExt>> call, Throwable t) {

            }
        });

        return v;
    }

    private void drawList(View v, List<AchvExt> list){
        LinearLayout scroll = v.findViewById(R.id.achv_container);

        for (AchvExt one : list
        ) {
            scroll.addView(fillOne(one));
        }
    }

    private LinearLayout fillOne(AchvExt one){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        NestedScrollView scrollView = new NestedScrollView(getActivity().getApplicationContext());
        LinearLayout card = new LinearLayout(getActivity().getApplicationContext());

        LinearLayout block = new LinearLayout(getActivity().getApplicationContext());
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams((int) (width * 0.92), (int) (height * 0.79));
        layoutParams.setMargins(0,0,15,0);
        block.setPadding(10,10,10,10);
        card.setBackgroundColor(getResources().getColor(R.color.card));
        block.setOrientation(LinearLayout.VERTICAL);
        block.setGravity(Gravity.CENTER);
        card.setGravity(Gravity.CENTER);
        block.setLayoutParams(
                new LinearLayout.LayoutParams((int) (width * 0.92), (int) (height * 0.79)));
        card.setLayoutParams(layoutParams);

        ImageView img = new ImageView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsImg =
                new LinearLayout.LayoutParams((int) (width * 0.5), (int) (width * 0.5));
        paramsImg.setMargins(0,0,0,20);
        img.setLayoutParams(paramsImg);

        if(one.getTitle() != null){
            Picasso.with(getActivity())
                    .load(R.drawable.cmpl_ach)
                    .into(img);
        }
        else {
            Picasso.with(getActivity())
                    .load(R.drawable.incomplete)
                    .into(img);
        }

        TextView nameText = new TextView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsText =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        paramsText.setMargins(0,0,0,30);
        nameText.setLayoutParams(paramsText);
        nameText.setTextSize(24);
        nameText.setText(one.getAchievement().getAchvName());

        TextView reqText = new TextView(getActivity().getApplicationContext());
        reqText.setLayoutParams(paramsText);
        reqText.setTextSize(16);
        reqText.setText(getString(R.string.achv_req) + " " + one.getAchievement().getAchvRequirement());

        LinearLayout goalLayout = new LinearLayout(getActivity().getApplicationContext());
        goalLayout.setOrientation(LinearLayout.HORIZONTAL);
        goalLayout.setLayoutParams(paramsText);
        TextView goalText = new TextView(getActivity().getApplicationContext());
        goalText.setTextSize(16);
        goalText.setText(getString(R.string.achv_goal) + one.getAchievement().getAchvGoal());
        goalText.setPadding(0,0,100,0);
        TextView stepText = new TextView(getActivity().getApplicationContext());
        stepText.setTextSize(16);
        stepText.setText(getString(R.string.achv_step) + one.getAchievement().getAchvStep());
        goalLayout.addView(goalText);
        goalLayout.addView(stepText);

        TextView rewText = new TextView(getActivity().getApplicationContext());
        rewText.setLayoutParams(paramsText);
        rewText.setTextSize(16);
        rewText.setBackgroundColor(getResources().getColor(R.color.back));
        rewText.setPadding(10,10,10,10);
        rewText.setText(getString(R.string.achv_reward) + one.getAchievement().getAchvReward().getRewardValue());

        LinearLayout rewLayout = new LinearLayout(getActivity().getApplicationContext());
        rewLayout.setOrientation(LinearLayout.HORIZONTAL);
        rewLayout.setLayoutParams(paramsText);
        TextView expText = new TextView(getActivity().getApplicationContext());
        expText.setTextSize(16);
        expText.setText(getString(R.string.achv_exp) + one.getAchievement().getAchvExp());
        expText.setPadding(0,0,100,0);
        TextView bonText = new TextView(getActivity().getApplicationContext());
        bonText.setTextSize(16);
        bonText.setText(getString(R.string.achv_bonuses) + one.getAchievement().getAchvBonuses());
        rewLayout.addView(expText);
        rewLayout.addView(bonText);

        TextView titleText = new TextView(getActivity().getApplicationContext());
        titleText.setLayoutParams(paramsText);
        titleText.setTextSize(16);
        titleText.setText(getString(R.string.achv_title) + " " + one.getAchievement().getAchvTitle());

        block.addView(img);
        block.addView(nameText);
        block.addView(reqText);
        block.addView(goalLayout);
        block.addView(rewText);
        block.addView(rewLayout);
        block.addView(titleText);

        scrollView.addView(block);
        card.addView(scrollView);

        return card;
    }
}