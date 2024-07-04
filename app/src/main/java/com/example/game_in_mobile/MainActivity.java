package com.example.game_in_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.example.game_in_mobile.ui.fragments.AchievementsFragment;
import com.example.game_in_mobile.ui.fragments.ProfileFragment;
import com.example.game_in_mobile.ui.fragments.QrFragment;
import com.example.game_in_mobile.ui.fragments.QuestFragment;
import com.example.game_in_mobile.ui.fragments.RaitingFragment;
import com.example.game_in_mobile.ui.fragments.RewardsFragment;
import com.example.game_in_mobile.ui.fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private int uid;
    private String role = "user";
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        getLoginData();
        FillMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void getLoginData(){
        Intent intent = getIntent();

        uid = intent.getIntExtra("id", 1);
        role = intent.getStringExtra("role");

        fragment = ProfileFragment.newInstance(uid);

        setFragment();
    }

    public void FillMenu() {
        final double SIZE_CONST = 0.15;

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        //Header
        /*
        View navView = navigationView.getHeaderView(0);
        ImageView img = navView.findViewById(R.id.userPic);
        TextView email = navView.findViewById(R.id.Email);
        TextView name = navView.findViewById(R.id.Name);

        MenuItem nav_bonuses = menu.findItem(R.id.nav_bonuses);
        nav_bonuses.setTitle(Html.fromHtml("Bonuses: <b>" + Storage.bonus + "</b>"));
        email.setText(Storage.email);
        name.setText(Storage.name);*/
        //setup pic
        /*Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp((float) (width / 2 * SIZE_CONST))
                .oval(false)
                .build();
        if (Storage.picture.length() < 5) {
            Picasso.get()
                    .load(R.drawable.default_user_pic)
                    .resize((int) (width * SIZE_CONST), (int) (width * SIZE_CONST))
                    .transform(transformation)
                    .into(img);
        } else {
            Picasso.get()
                    .load(Storage.picture)
                    .resize((int) (width * SIZE_CONST), (int) (width * SIZE_CONST))
                    .transform(transformation)
                    .placeholder(R.drawable.default_user_pic)
                    .into(img);
        }*/
        //------------------------------------------------------------------------------Menu
        MenuItem nav_profile = menu.findItem(R.id.nav_profile);
        nav_profile.setOnMenuItemClickListener(item -> {
            fragment = ProfileFragment.newInstance(uid);

            setFragment();

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem nav_reward = menu.findItem(R.id.nav_rewards);
        nav_reward.setOnMenuItemClickListener(item -> {
            fragment = RewardsFragment.newInstance(role, uid);

            setFragment();

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem nav_achvs = menu.findItem(R.id.nav_achvs);
        nav_achvs.setOnMenuItemClickListener(item -> {
            fragment = AchievementsFragment.newInstance(uid, role);

            setFragment();

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem nav_quest = menu.findItem(R.id.nav_quests);
        nav_quest.setOnMenuItemClickListener(item -> {
            fragment = QuestFragment.newInstance(uid, role);

            setFragment();

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem nav_raitings = menu.findItem(R.id.nav_raitings);
        nav_raitings.setOnMenuItemClickListener(item -> {
            fragment = RaitingFragment.newInstance(uid, role);

            setFragment();

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem nav_qr = menu.findItem(R.id.nav_qr);
        nav_qr.setOnMenuItemClickListener(item -> {
            fragment = QrFragment.newInstance(uid);

            setFragment();

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem nav_settings = menu.findItem(R.id.settings);
        nav_settings.setOnMenuItemClickListener(item -> {
            Intent intent = new Intent(MainActivity.this, Setings.class);
            intent.putExtra("id", uid);
            intent.putExtra("role", role);

            startActivity(intent);

            return false;
        });
        //--------------------------------------------------------------------------------

        MenuItem log_out = menu.findItem(R.id.log_out);
        log_out.setOnMenuItemClickListener(item -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            startActivity(intent);

            return false;
        });
        //--------------------------------------------------------------------------------
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

    }
}