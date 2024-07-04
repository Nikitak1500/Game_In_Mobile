package com.example.game_in_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Console;

import facedes.RetrofitFacade;
import models.AuthResp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void logIn(View view) {


        EditText login = findViewById(R.id.editTextTextPersonName);
        EditText pass = findViewById(R.id.editTextTextPassword);
        Call<AuthResp> call = RetrofitFacade.auth(
                login.getText().toString(),
                pass.getText().toString());

        call.enqueue(new Callback<AuthResp>() {
            @Override
            public void onResponse(Call<AuthResp> call, Response<AuthResp> response) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("id", response.body().getId());
                intent.putExtra("role", response.body().getRole());

                startActivity(intent);
            }

            @Override
            public void onFailure(Call<AuthResp> call, Throwable t) {
                System.out.println(t);
            }
        });


    }

    @Override
    public void onBackPressed() {

    }
}