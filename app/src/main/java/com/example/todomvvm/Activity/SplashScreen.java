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
//    private static final long SPLASH_TIMEOUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        viewModel = ViewModelProviders.of(this).get(SplashScreenViewModel.class);
        handleFragment(new SplashScreenFragment());

//        viewModel = ViewModelProviders.of(this).get(SplashScreenViewModel.class);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent  = new Intent(SplashScreen.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },SPLASH_TIMEOUT);

    }
    private void handleFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutSplash, fragment);
        transaction.commit();
    }
}
