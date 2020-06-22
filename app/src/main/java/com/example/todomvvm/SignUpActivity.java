package com.example.todomvvm;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.User;
import com.example.todomvvm.database.UserDao;

public class SignUpActivity extends AppCompatActivity {

//    private EditText edtName;
//    private EditText edtLastName;
//    private EditText edtEmail;
//    private EditText edtPassword;
//
//    private Button btCancel;
//    private Button btRegister;
//
//    private UserDao userDao;
//
//    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        handleFragment(new SignUpFragment());

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Registering...");
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setProgress(0);
//
//
//        edtName = findViewById(R.id.nameinput);
//        edtLastName = findViewById(R.id.lastnameinput);
//        edtEmail = findViewById(R.id.emailinput);
//        edtPassword = findViewById(R.id.passwordinput);
//
//        btCancel = findViewById(R.id.btCancel);
//        btRegister = findViewById(R.id.btRegister);
//
//        userDao = Room.databaseBuilder(this, AppDatabase.class, "mi-database.db")
//                .allowMainThreadQueries()
//                .build()
//                .getUserDao();
//
//        btCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//            }
//        });
//
//        btRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!isEmpty()) {
//
//                    progressDialog.show();
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            User user = new User(edtName.getText().toString(), edtLastName.getText().toString(),
//                                    edtEmail.getText().toString(), edtPassword.getText().toString());
//                            userDao.insert(user);
//                            progressDialog.dismiss();
//                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//                            finish();
//                        }
//                    }, 1000);
//
//                } else {
//                    Toast.makeText(SignUpActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    private boolean isEmpty() {
//        if (TextUtils.isEmpty(edtEmail.getText().toString()) ||
//                TextUtils.isEmpty(edtPassword.getText().toString()) ||
//                TextUtils.isEmpty(edtName.getText().toString()) ||
//                TextUtils.isEmpty(edtLastName.getText().toString())
//        ) {
//            return true;
//        } else {
//            return false;
//        }
    }

    private void handleFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}
