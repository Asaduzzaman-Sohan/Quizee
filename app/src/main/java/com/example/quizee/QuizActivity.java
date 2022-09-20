package com.example.quizee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private Timer quizTimer;

    TextView questions;
    TextView question;

    AppCompatButton option1;
    AppCompatButton option2;
    AppCompatButton option3;
    AppCompatButton option4;
    AppCompatButton nextBtn;

    ImageView backBtn;

    TextView timer;
    TextView selectedTopicName;

    String getSelectedTopicName;

    private int totalTimeInMins = 1;
    private int seconds = 0;

    private List<QuestionList> questionLists;

    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        backBtn = findViewById(R.id.backBtn);
        timer= findViewById(R.id.timer);
        selectedTopicName = findViewById((R.id.topicName));

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nextBtn);

        getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        questionLists =QuestionBank.getQuestions(getSelectedTopicName);

        startTimer(timer);

        questions.setText((currentQuestionPosition + 1) + "/" + questionLists.size());
        question.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());

        question.setText(questionLists.get(1).getQuestion());
        option1.setText(questionLists.get(1).getOption1());
        option2.setText(questionLists.get(1).getOption2());
        option3.setText(questionLists.get(1).getOption3());
        option4.setText(questionLists.get(1).getOption4());

        question.setText(questionLists.get(2).getQuestion());
        option1.setText(questionLists.get(2).getOption1());
        option2.setText(questionLists.get(2).getOption2());
        option3.setText(questionLists.get(2).getOption3());
        option4.setText(questionLists.get(2).getOption4());

        question.setText(questionLists.get(3).getQuestion());
        option1.setText(questionLists.get(3).getOption1());
        option2.setText(questionLists.get(3).getOption2());
        option3.setText(questionLists.get(3).getOption3());
        option4.setText(questionLists.get(3).getOption4());



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.red_btn);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.red_btn);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.red_btn);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.red_btn);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else {
                    changeNextQuestion();

                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();

            }
        });

    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if ((currentQuestionPosition+1) == questionLists.size()){
            nextBtn.setText("Submit Quiz");
        }

        if (currentQuestionPosition < questionLists.size()){
             selectedOptionByUser = "";

             option1.setBackgroundResource(R.drawable.round_back_white2);
             option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white2);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white2);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white2);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition + 1) + "/" + questionLists.size());
            question.setText(questionLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionLists.get(currentQuestionPosition).getOption4());
        }

        else {
            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("correct", getCorrectAnswer());
            intent.putExtra("incorrect", getIncorrectAnswer());
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (seconds == 0){
                    totalTimeInMins --;
                    seconds = 59;
                }
                else if(seconds == 0 && totalTimeInMins == 0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResult.class);
                    intent.putExtra("correct", getCorrectAnswer());
                    intent.putExtra("incorrent", getIncorrectAnswer());
                    startActivity(intent);

                    finish();
                }

                else{
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0"+finalMinutes;
                        }
                        if (finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }

                        timerTextView.setText(finalMinutes + " : " + finalSeconds);
                    }
                });

            }
        }, 1000, 1000);
    }
    private  int getCorrectAnswer(){

        int correctAnswers = 0;

        for (int i = 0; i < questionLists.size(); i++){

            final String getUserSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private  int getIncorrectAnswer(){

        int correctAnswers = 0;

        for (int i = 0; i < questionLists.size(); i++){

            final String getUserSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();

    }


    private void revealAnswer(){

        final String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.green_quiz);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.green_quiz);
            option2.setTextColor(Color.WHITE);
        }
        else if (option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.green_quiz);
            option3.setTextColor(Color.WHITE);
        }
       else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.green_quiz);
            option4.setTextColor(Color.WHITE);
        }
    }
}


























