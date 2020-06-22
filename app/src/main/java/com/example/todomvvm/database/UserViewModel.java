//package com.example.todomvvm.database;
//
//import android.app.Application;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.LiveData;
//
//public class UserViewModel extends AndroidViewModel {
//    public UserViewModel(@NonNull Application application) {
//        super(application);
//    }
//    public LiveData<User> getUser(String email, String password) {
//        return userRepository.getUser(email, password);
//    }
//
//    public void addUser(User user) {
//        userRepository.addUser(user);
//    }
//
//    public LiveData<User> getUserByEmail(String email) {
//        return userRepository.getUserByEmail(email);
//    }
//    public LiveData<User> getUserById(int id) {
//        return userRepository.getUserByIdInLiveData(id);
//    }
//}
