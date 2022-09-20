package com.example.quizee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName = "";

    LinearLayout java;
    LinearLayout javaScript;
    LinearLayout c;
    LinearLayout python;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        java = findViewById(R.id.javaLang);
        javaScript = findViewById(R.id.jsLang);
        c = findViewById(R.id.cLang);
        python = findViewById(R.id.pyLang);


        startBtn = findViewById(R.id.startQuizBtn);

        java.setOnClickListener(view -> {

            selectedTopicName = "java";
            java.setBackgroundResource(R.drawable.round_back_white);

            javaScript.setBackgroundResource(R.drawable.round_back);
            c.setBackgroundResource(R.drawable.round_back);
            python.setBackgroundResource(R.drawable.round_back);

        });

        javaScript.setOnClickListener(view -> {
            selectedTopicName = "javaScript";
            javaScript.setBackgroundResource(R.drawable.round_back_white);

            java.setBackgroundResource(R.drawable.round_back);
            c.setBackgroundResource(R.drawable.round_back);
            python.setBackgroundResource(R.drawable.round_back);

        });

        c.setOnClickListener(view -> {
            selectedTopicName = "c";
            c.setBackgroundResource(R.drawable.round_back_white);

            java.setBackgroundResource(R.drawable.round_back);
            javaScript.setBackgroundResource(R.drawable.round_back);
            python.setBackgroundResource(R.drawable.round_back);

        });

        python.setOnClickListener(view -> {
            selectedTopicName = "python";
            python.setBackgroundResource(R.drawable.round_back_white);

            java.setBackgroundResource(R.drawable.round_back);
            javaScript.setBackgroundResource(R.drawable.round_back);
            c.setBackgroundResource(R.drawable.round_back);
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTopicName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please select the topic", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }
            }
        });

    }
}