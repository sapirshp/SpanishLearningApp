package com.example.palabra;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    static int SECOND_SCREEN = 1;
    static int EXIT_APP = 0;
    static int PLAY_AGAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ask_question();
    }

    protected void ask_question()
    {
        final Question current_quest = Question.get_question();

        ImageView img = (ImageView)findViewById(R.id.appImageView);
        Drawable apple = getResources().getDrawable(R.drawable.apple);
        img.setImageDrawable(apple);    // make modular in next update


        Button button_answer_a = findViewById(R.id.answer_a);
        button_answer_a.setText(current_quest.getAnswer(1));
        button_answer_a.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View V)
            {
                buttonClick(current_quest.getCorrectAnsInt(), 1, current_quest.getCorrectAnsStr());
            }
        });

        Button button_answer_b = findViewById(R.id.answer_b);
        button_answer_b.setText(current_quest.getAnswer(2));
        button_answer_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(current_quest.getCorrectAnsInt(), 2, current_quest.getCorrectAnsStr());
            }
        });

        Button button_answer_c = findViewById(R.id.answer_c);
        button_answer_c.setText(current_quest.getAnswer(3));
        button_answer_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(current_quest.getCorrectAnsInt(), 3, current_quest.getCorrectAnsStr());
            }
        });

        Button button_answer_d = findViewById(R.id.answer_d);
        button_answer_d.setText(current_quest.getAnswer(4));
        button_answer_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(current_quest.getCorrectAnsInt(), 4, current_quest.getCorrectAnsStr());
            }
        });
    }


    public void buttonClick(int correct_ans, int user_choice, String str_correct_answer)
    {
        Intent goToAnsScreen = new Intent(getApplicationContext(), answerScreen.class);
        boolean is_correct = false;
        if(correct_ans == user_choice)
        {
            is_correct = true;
        }
        goToAnsScreen.putExtra("IS_CORRECT", is_correct);
        goToAnsScreen.putExtra("ANSWER", str_correct_answer);

        startActivityForResult(goToAnsScreen, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == SECOND_SCREEN)
        {
            if(resultCode == EXIT_APP)
            {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            if(resultCode == PLAY_AGAIN)
            {
                Intent goToAnsScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToAnsScreen);
            }
        }
    }


}
