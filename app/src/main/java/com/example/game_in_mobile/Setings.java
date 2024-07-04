package com.example.game_in_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.game_in_mobile.ui.fragments.ProfileFragment;

import java.util.Locale;

public class Setings extends AppCompatActivity {
    private int uid;
    private String role = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setings);

        getLoginData();

        Button button = findViewById(R.id.confirmSettings);
        button.setOnClickListener(this::changeLanguage);
    }

    private void getLoginData(){
        Intent intent = getIntent();

        uid = intent.getIntExtra("id", 1);
        role = intent.getStringExtra("role");
    }

    public void changeLanguage(View view){
        RadioButton ua = findViewById(R.id.ukrRadio);
        RadioButton en = findViewById(R.id.engRadio);

        if(ua.isChecked()){
            Locale locale = new Locale("uk");
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            getResources().updateConfiguration(configuration, null);
        }
        if(en.isChecked()){
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            getResources().updateConfiguration(configuration, null);
        }

        Intent intent = new Intent(Setings.this, MainActivity.class);
        intent.putExtra("id", uid);
        intent.putExtra("role", role);

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Setings.this, MainActivity.class);
        intent.putExtra("id", uid);
        intent.putExtra("role", role);

        startActivity(intent);
    }
}