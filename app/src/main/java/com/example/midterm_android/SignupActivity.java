package com.example.midterm_android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private Button buttonSignup;
    private EditText editTextEmail;
    private EditText editTextHoTen;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private ProgressBar progressBar;
    private TextView textViewLoginLink;
    private SinhVien sinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViews();

        buttonSignup.setOnClickListener(v -> {
            String textEmail = editTextEmail.getText().toString();
            String textHoTen = editTextHoTen.getText().toString();
            String textPassword = editTextPassword.getText().toString();
            String textConfirmPassword = editTextConfirmPassword.getText().toString();

            //check if all the data are present
            if (TextUtils.isEmpty(textEmail)) {
                editTextEmail.setError("Please enter your email");
                editTextEmail.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                editTextEmail.setError("Invalid email");
                editTextEmail.requestFocus();
            } else if (TextUtils.isEmpty(textPassword)) {
                editTextPassword.setError("Please enter your password");
                editTextPassword.requestFocus();
            } else if (TextUtils.isEmpty(textConfirmPassword)) {
                editTextConfirmPassword.setError("Please confirm your password");
                editTextConfirmPassword.requestFocus();
            } else if (!textPassword.equals(textConfirmPassword)) {
                editTextConfirmPassword.setError("Passwords do not match");
                editTextConfirmPassword.requestFocus();
            } else if (textPassword.length() < 6) {
                editTextPassword.setError("Password must be at least 6 characters");
                editTextPassword.requestFocus();
            } else {
                progressBar.setVisibility(ProgressBar.VISIBLE);
                Intent intent = new Intent(this, LoginActivity.class);
                sinhVien = new SinhVien(textHoTen, textEmail, textPassword);
                intent.putExtra("sinhvien", sinhVien);
                startActivity(intent);
            }
        });

        textViewLoginLink.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
        });
    }

    private void findViews() {
        buttonSignup = findViewById(R.id.button_signup);
        editTextEmail = findViewById(R.id.editTextTextPersonName_signup);
        editTextHoTen = findViewById(R.id.editTextName_signup);
        editTextPassword = findViewById(R.id.editTextPass_signup);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPass);
        progressBar = findViewById(R.id.progressBarSignup);
        textViewLoginLink = findViewById(R.id.textView_login_link);
    }
}