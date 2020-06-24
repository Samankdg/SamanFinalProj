package com.example.todomvvm.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.todomvvm.Fragments.LoginFragment;
import com.example.todomvvm.R;

public class LoginActivity extends AppCompatActivity {

//    private Button btSignIn;
//    private Button btSignUp;
//    private EditText edtEmail;
//    private EditText edtPassword;
//    private AppDatabase database;
//
//    private UserDao userDao;
//    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        handleFragment(new LoginFragment());

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Check User...");
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setProgress(0);
//
//
//        database = Room.databaseBuilder(this, AppDatabase.class, "mi-database.db")
//                .allowMainThreadQueries()
//                .build();
//
//        userDao = database.getUserDao();
//
//
//        btSignIn = findViewById(R.id.btSignIn);
//        btSignUp = findViewById(R.id.btSignUp);
//
//        edtEmail = findViewById(R.id.emailinput);
//        edtPassword = findViewById(R.id.passwordinput);
//
//
//
//        btSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
//            }
//        });
//        btSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!emptyValidation()) {
//                    progressDialog.show();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            User user = userDao.getUser(edtEmail.getText().toString(), edtPassword.getText().toString());
//                            if(user!=null){
//                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                                i.putExtra("User", user);
//                                finish();
//                                startActivity(i);
//                            }else{
//                                Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
//                            }
//                            progressDialog.dismiss();
//                        }
//                    }, 1000);
//
//                }else{
//                    Toast.makeText(LoginActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//
//    }
//
//    private boolean emptyValidation() {
//        if (TextUtils.isEmpty(edtEmail.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())) {
//            return true;
//        }else {
//            return false;
//        }
//    }
    }
    private void handleFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutLogin, fragment);
        transaction.commit();
    }
}

