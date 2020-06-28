package com.eyasumulugeta.quizgameapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button asia, america, europe, all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        all = findViewById(R.id.all);
        all.setOnClickListener(this);
        asia = findViewById(R.id.asia);
        asia.setOnClickListener(this);
        america= findViewById(R.id.america);
        america.setOnClickListener(this);
        europe = findViewById(R.id.europe);
        europe.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int quizCategory = 0; //All

        switch (view.getId()) {
            case R.id.asia:
                quizCategory = 1;
                break;
            case R.id.america:
                quizCategory = 2;
                break;
            case R.id.europe:
                quizCategory = 3;
                break;
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("QUIZ_CATEGORY", quizCategory);
        startActivity(intent);
    }
}
