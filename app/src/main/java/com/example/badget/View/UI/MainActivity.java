package com.example.badget.View.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.badget.R;
import com.example.badget.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
    }
}