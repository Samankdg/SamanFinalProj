package com.example.todomvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.todomvvm.tasks.MainActivity;
import com.google.android.material.navigation.NavigationView;

public class CalendarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CalendarActivityViewModel viewModel;
    CalendarView calendarView;
    TextView myCalendar;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        viewModel = ViewModelProviders.of(this).get(CalendarActivityViewModel.class);

        drawerLayout = findViewById(R.id.drawer_layout_calendar);
        navigationView = findViewById(R.id.nav_view);


        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myCalendar = (TextView) findViewById(R.id.myCalendar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                String date = (i1+ 1) + "/" + i2 + "/" + i;
                myCalendar.setText(date);
            }
        });
    }
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.nav_calendar:
                Intent intent1 = new Intent(CalendarActivity.this, CalendarActivity.class);
                startActivity(intent1);
                break;

            case R.id.nav_logout:
                Intent intent2 = new Intent(CalendarActivity.this, LoginActivity.class);
                finish();
                startActivity(intent2);
                break;

            case R.id.nav_exit:
                finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
