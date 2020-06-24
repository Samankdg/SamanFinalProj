package com.example.todomvvm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.todomvvm.Fragments.SplashScreenFragment;
import com.example.todomvvm.R;
import com.example.todomvvm.ViewModel.SplashScreenViewModel;

public class SplashScreen extends AppCompatActivity {

    SplashScreenViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        viewModel = ViewModelProviders.of(this).get(SplashScreenViewModel.class);

        handleFragment(new SplashScreenFragment());

    }
    private void handleFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutSplash, fragment);
        transaction.commit();
    }
}
