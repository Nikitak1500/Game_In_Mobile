package com.example.game_in_mobile.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.game_in_mobile.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import facedes.RetrofitFacade;
import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QrFragment extends Fragment {

    private static final String UID_ARG = "uid";

    private int uid;

    public QrFragment() {
        // Required empty public constructor
    }


    public static QrFragment newInstance(int uid) {
        QrFragment fragment = new QrFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qr, container, false);

        RetrofitFacade.accInfo(uid).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                printQR(response.body(), view);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return view;
    }

    private void printQR(User user, View view){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        LinearLayout layout = view.findViewById(R.id.qr_containier);
        ImageView image = new ImageView(getActivity().getApplicationContext());
        image.setLayoutParams(
                new LinearLayout.LayoutParams((int) (width * 0.7), (int) (width * 0.7)));
        image.setImageBitmap(generateQR(user.getIduser() + ";"
                + user.getUserName() + ";" + user.getEmail()));
        layout.addView(image);
    }

    private Bitmap generateQR(String content){
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE,
                    512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            return bmp;

        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}