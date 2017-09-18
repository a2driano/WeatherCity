package com.a2driano.city.my.weather.presenter.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.presenter.view.FragmentDetail;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        startFragment();
    }

    private void startFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        FragmentDetail fragment = FragmentDetail.newInstance();
        transaction.add(R.id.container_detail, fragment)
                .addToBackStack(null)
                .commit();
    }
}
