package com.example.midterm_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView;
        TextView textView;

        imageView = findViewById(R.id.img_senda);
        textView = findViewById(R.id.tv_title);

        Bundle bundle;
        bundle = getIntent().getExtras();
        if (bundle != null) {
            Senda senda = (Senda) bundle.getSerializable("senda");

            imageView.setImageResource(senda.getResourceId());
            textView.setText(senda.getTitle());
        }
    }
}