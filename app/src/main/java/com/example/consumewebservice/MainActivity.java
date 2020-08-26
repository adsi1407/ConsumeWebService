package com.example.consumewebservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.consumewebservice.viewmodel.BrandViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private BrandViewModel brandViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandViewModel = new ViewModelProvider(this).get(BrandViewModel.class);
        brandViewModel.getAllBrands().observe(this, brands -> {
            Log.println(Log.VERBOSE, "Brands", "Brands");
        });
    }
}