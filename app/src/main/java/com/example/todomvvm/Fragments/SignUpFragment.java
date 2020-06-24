package com.example.todomvvm.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todomvvm.Activity.LoginActivity;
import com.example.todomvvm.R;
import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Tables.User;
import com.example.todomvvm.database.UserDao;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private EditText edtName;
    private EditText edtLastName;
    private EditText edtEmail;
    private EditText edtPassword;

    private Button btCancel;
    private Button btRegister;

    private UserDao userDao;

    private ProgressDialog progressDialog;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);


        edtName = v.findViewById(R.id.nameinput);
        edtLastName = v.findViewById(R.id.lastnameinput);
        edtEmail = v.findViewById(R.id.emailinput);
        edtPassword = v.findViewById(R.id.passwordinput);

        btCancel = v.findViewById(R.id.btCancel);
        btRegister = v.findViewById(R.id.btRegister);

        userDao = Room.databaseBuilder(getActivity(), AppDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty()) {

                    progressDialog.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(edtName.getText().toString(), edtLastName.getText().toString(),
                                    edtEmail.getText().toString(), edtPassword.getText().toString());
                            userDao.insert(user);
                            progressDialog.dismiss();
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                            getActivity().finish();
                        }
                    }, 1000);

                } else {
                    Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
    private boolean isEmpty() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) ||
                TextUtils.isEmpty(edtPassword.getText().toString()) ||
                TextUtils.isEmpty(edtName.getText().toString()) ||
                TextUtils.isEmpty(edtLastName.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }
}
