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
import models.Place;
import models.Raiting;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacesFragment extends Fragment {

    private static final String ARG_UID = "uid";
    private static final String ARG_ID = "raiting";

    private int uid;
    private int id;

    public PlacesFragment() {
        // Required empty public constructor
    }

    public static PlacesFragment newInstance(int uid, int raitingID) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_UID, uid);
        args.putInt(ARG_ID, raitingID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uid = getArguments().getInt(ARG_UID);
            id = getArguments().getInt(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_places, container, false);

        RetrofitFacade.getPlaces(id).enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                drawList(v, response.body());
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {

            }
        });

        return v;
    }

    private void drawList(View v, List<Place> list){
        LinearLayout scroll = v.findViewById(R.id.places_containier);

        scroll.addView(fillRaiting(list.get(0).getIdraiting()));

        for (Place one : list
        ) {
            scroll.addView(fillOne(one, list.indexOf(one)));
        }
    }

    private LinearLayout fillRaiting(Raiting raiting) {
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
        nameText.setText(raiting.getRaitingName());

        TextView reqText = new TextView(getActivity().getApplicationContext());
        reqText.setLayoutParams(paramsText);
        reqText.setTextSize(16);
        reqText.setText(getString(R.string.raiting_place_req) + " " + raiting.getRaitingRequirement());

        TextView stepText = new TextView(getActivity().getApplicationContext());
        stepText.setLayoutParams(paramsText);
        stepText.setTextSize(16);
        stepText.setText(getString(R.string.raiting_place_step) + " " + raiting.getRaitingStep());

        TextView rewText = new TextView(getActivity().getApplicationContext());
        rewText.setLayoutParams(paramsText);
        rewText.setTextSize(16);
        rewText.setBackgroundColor(getResources().getColor(R.color.back));
        rewText.setPadding(10,10,10,10);
        rewText.setText(getString(R.string.raiting_place_reward) + raiting.getRaitingRewards());

        TextView winText = new TextView(getActivity().getApplicationContext());
        winText.setLayoutParams(paramsText);
        winText.setTextSize(16);
        winText.setText(getString(R.string.raiting_place_win) + " " + raiting.getRaitingWinners());

        block.addView(img);
        block.addView(nameText);
        block.addView(reqText);
        block.addView(stepText);
        block.addView(rewText);
        block.addView(winText);

        scrollView.addView(block);
        card.addView(scrollView);

        return card;
    }

    private LinearLayout fillOne(Place one, int i){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        LinearLayout block = new LinearLayout(getActivity().getApplicationContext());
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams((int) (width * 0.92), (int) (height * 0.79));
        layoutParams.setMargins(0,0,15,0);
        block.setPadding(10,10,10,10);
        block.setBackgroundColor(getResources().getColor(R.color.card_1));
        block.setOrientation(LinearLayout.VERTICAL);
        block.setGravity(Gravity.CENTER);
        block.setLayoutParams(layoutParams);

        ImageView img = new ImageView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams paramsImg =
                new LinearLayout.LayoutParams((int) (width * 0.5), (int) (width * 0.5));
        paramsImg.setMargins(0,0,0,20);
        img.setLayoutParams(paramsImg);
        Picasso.with(getActivity())
                .load(R.drawable.place)
                .into(img);

        LinearLayout.LayoutParams paramsText =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        paramsText.setMargins(0,0,0,20);

        TextView placeText = new TextView(getActivity().getApplicationContext());
        placeText.setLayoutParams(paramsText);
        placeText.setTextSize(24);
        placeText.setText(Integer.toString(i + 1));

        TextView userText = new TextView(getActivity().getApplicationContext());
        userText.setLayoutParams(paramsText);
        userText.setTextSize(20);
        userText.setText(one.getIduser().getUserName());

        TextView mailText = new TextView(getActivity().getApplicationContext());
        mailText.setLayoutParams(paramsText);
        mailText.setTextSize(16);
        mailText.setText(getString(R.string.place_email) + " " + one.getIduser().getEmail());

        TextView valueText = new TextView(getActivity().getApplicationContext());
        valueText.setLayoutParams(paramsText);
        valueText.setTextSize(24);
        valueText.setText(getString(R.string.place_val) + " " + Integer.toString(one.getPlaceValue()));

        block.addView(img);
        block.addView(placeText);
        block.addView(userText);
        block.addView(mailText);
        block.addView(valueText);

        return block;
    }
}