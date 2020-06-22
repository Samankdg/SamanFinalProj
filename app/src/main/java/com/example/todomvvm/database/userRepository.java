//package com.example.todomvvm.database;
//
//import android.app.Application;
//import android.os.AsyncTask;
//import androidx.lifecycle.LiveData;
//
//public class userRepository {
//
//    private UserDao userDao;
//
//    public userRepository(Application application) {
//        userDao = AppDatabase.getInstance(application).getUserDao();
//    }
//
//    public LiveData<User> getUser(String email, String password) {
//        return userDao.loginWithEmailAndPassword(email, password);
//    }
//
//    public LiveData<User> getUserByEmail(String email) {
//        return userDao.getUser(email);
//    }
//
//    public void addUser(User user){
//        new AddUserAsyncTask(userDao).execute(user);
//    }
//
//    public User getUserByUserId(int id) {
//        return userDao.getUserById(id);
//    }
//
//    public LiveData<User> getUserByIdInLiveData(int id) {
//        return userDao.getUserByIdInLiveData(id);
//    }
//
//    private static class AddUserAsyncTask extends AsyncTask<User, Void, Void> {
//
//        private UserDao userDao;
//
//        private AddUserAsyncTask(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(User... users) {
//            userDao.addUser(users[0]);
//            return null;
//        }
//    }
//}
//
