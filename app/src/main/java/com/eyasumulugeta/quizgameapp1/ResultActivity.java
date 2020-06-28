package com.eyasumulugeta.quizgameapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultLabel, totalScoreLabel;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultLabel = findViewById(R.id.resultLabel);
        totalScoreLabel = findViewById(R.id.totalScoreLabel);
        backBtn = findViewById(R.id.returnBtn);
        backBtn.setOnClickListener(this);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);

        int totalScore = settings.getInt("totalScore", 0);
        totalScore += score;

        resultLabel.setText(score + "/ 5");
        totalScoreLabel.setText("Total Score: " + totalScore);

        //update total score.
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }
}
