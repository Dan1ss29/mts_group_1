package com.example.pw2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.goBack);
        button.setOnClickListener(v -> goBack());
    }
    public void goBack(){
        finishAffinity();
        startActivity(new Intent(this, MainActivity.class));
    }
}