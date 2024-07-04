package com.example.game_in_mobile.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.game_in_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import facedes.RetrofitFacade;
import models.AchvExt;
import models.Raiting;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RaitingFragment extends Fragment {

    private static final String ARG_UID = "uid";
    private static final String ARG_ROLE = "role";

    private int uid;
    private String role;

    public RaitingFragment() {
        // Required empty public constructor
    }

    public static RaitingFragment newInstance(int uid, String role) {
        RaitingFragment fragment = new RaitingFragment();
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
        View v = inflater.inflate(R.layout.fragment_raiting, container, false);

        RetrofitFacade.getRaitings().enqueue(new Callback<List<Raiting>>() {
            @Override
            public void onResponse(Call<List<Raiting>> call, Response<List<Raiting>> response) {
                drawList(v, response.body());
            }

            @Override
            public void onFailure(Call<List<Raiting>> call, Throwable t) {

            }
        });

        return v;
    }

    private void drawList(View v, List<Raiting> list){
        LinearLayout scroll = v.findViewById(R.id.raiting_containier);

        for (Raiting one : list
        ) {
            scroll.addView(fillOne(one));
        }
    }

    private LinearLayout fillOne(Raiting one){
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
        card.setGravity(Gravity.CENTER);
        block.setGravity(Gravity.CENTER);
        block.setLayoutParams(
                new LinearLayout.LayoutParams((int) (width * 0.92), (int) (height * 0.79)));
        card.setLayoutParams(layoutParams);

        ImageView img = new ImageView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsImg =
                new LinearLayout.LayoutParams((int) (width * 0.5), (int) (width * 0.5));
        paramsImg.setMargins(0,0,0,20);
        img.setLayoutParams(paramsImg);
        Picasso.with(getActivity())
                .load(R.drawable.raiting)
                .into(img);

        TextView nameText = new TextView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsText =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        paramsText.setMargins(0,0,0,30);
        nameText.setLayoutParams(paramsText);
        nameText.setTextSize(24);
        nameText.setText(one.getRaitingName());

        TextView reqText = new TextView(getActivity().getApplicationContext());
        reqText.setLayoutParams(paramsText);
        reqText.setTextSize(16);
        reqText.setText(getString(R.string.raiting_req) + " " + one.getRaitingRequirement());

        TextView stepText = new TextView(getActivity().getApplicationContext());
        stepText.setLayoutParams(paramsText);
        stepText.setTextSize(16);
        stepText.setText(getString(R.string.raiting_step) + " " + one.getRaitingStep());

        TextView rewText = new TextView(getActivity().getApplicationContext());
        rewText.setLayoutParams(paramsText);
        rewText.setTextSize(16);
        rewText.setBackgroundColor(getResources().getColor(R.color.back));
        rewText.setPadding(10,10,10,10);
        rewText.setText(getString(R.string.raiting_reward) + one.getRaitingRewards());

        TextView winText = new TextView(getActivity().getApplicationContext());
        winText.setLayoutParams(paramsText);
        winText.setTextSize(16);
        winText.setText(getString(R.string.raiting_win) + " " + one.getRaitingWinners());

        Button button = new Button(getActivity().getApplicationContext());
        button.setLayoutParams(paramsText);
        button.setTextSize(20);
        button.setText(getString(R.string.view_places));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = PlacesFragment.newInstance(uid, one.getIdraiting());

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.commit();
            }
        });

        block.addView(img);
        block.addView(nameText);
        block.addView(reqText);
        block.addView(stepText);
        block.addView(rewText);
        block.addView(winText);
        block.addView(button);

        scrollView.addView(block);
        card.addView(scrollView);

        return card;
    }
}