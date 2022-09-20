package com.example.quizee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuizBtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswer);
        final TextView incorrectAnswer = findViewById(R.id.incorrectAnswer);


        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getIncorrectAnswer = getIntent().getIntExtra("incorrect", 0);

        correctAnswer.setText(String.valueOf(getCorrectAnswers));
        incorrectAnswer.setText(String.valueOf(getIncorrectAnswer));

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResult.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResult.this, MainActivity.class));
        finish();
    }
}