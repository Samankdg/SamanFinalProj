package com.example.todomvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.todomvvm.database.AppDatabase;

public class CalendarActivityViewModel extends AndroidViewModel {
    public CalendarActivityViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
    }
}
