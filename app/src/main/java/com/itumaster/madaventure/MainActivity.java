package com.itumaster.madaventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnButtonClickListener {


    private LoginFragment loginFragment;
    private AccueilFragment accueilFragment;
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = new LoginFragment();
        accueilFragment = new AccueilFragment();
        detailFragment = new DetailFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, loginFragment)
                .commit();



        Button btnAccueil = findViewById(R.id.button);
        btnAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, accueilFragment)
                        .commit();
            }
        });

        Button btnDetail = findViewById(R.id.button2);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, detailFragment)
                        .commit();
            }
        });

        Button btnLogin = findViewById(R.id.button3);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, loginFragment)
                        .commit();
            }
        });

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (currentFragment instanceof LoginFragment) {
            btnAccueil.setVisibility(View.GONE);
            btnDetail.setVisibility(View.GONE);
            btnLogin.setVisibility(View.GONE);
        }


    }

    @Override
    public void onButtonClicked(String username) {
        accueilFragment = new AccueilFragment();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        accueilFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, accueilFragment)
                .commit();
    }
}