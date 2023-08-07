package com.itumaster.madaventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnButtonClickListener {


    private LoginFragment loginFragment;
    private AccueilFragment accueilFragment;
    private DetailFragment detailFragment;
    private FormlieuFragment formlieuFragment;
    private ProvinceFragment provinceFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = new LoginFragment();
        accueilFragment = new AccueilFragment();
        detailFragment = new DetailFragment();
        formlieuFragment = new FormlieuFragment();
        provinceFragment = new ProvinceFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, accueilFragment)
                .commit();

        /*Button btnAccueil = findViewById(R.id.button);
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

        Button btnTest = findViewById(R.id.button4);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, provinceFragment)
                        .commit();
            }
        });*/
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

    /*public void hideButtons() {
        Button btnAccueil = findViewById(R.id.button);
        Button btnDetail = findViewById(R.id.button2);
        Button btnLogin = findViewById(R.id.button3);
        Button btnTest = findViewById(R.id.button4);
        btnAccueil.setVisibility(View.GONE);
        btnDetail.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        btnTest.setVisibility(View.GONE);
    }*/
}