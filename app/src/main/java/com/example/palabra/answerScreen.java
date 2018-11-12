package com.example.palabra;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.palabra.QuestionsDB.getQuestionsAmount;
import static com.example.palabra.QuestionsDB.score;
import static com.example.palabra.QuestionsDB.cicleProgress;



public class answerScreen extends AppCompatActivity {

    private static long back_pressed;

    public static String getPerformanceMetric() {
        return String.valueOf(score) + "/" + String.valueOf(cicleProgress);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_screen);

        RelativeLayout backLayout = (RelativeLayout) findViewById(R.id.back);

        String message;
        TextView is_correct_box = findViewById(R.id.is_correct_text_view);
        TextView correct_answer_text = findViewById(R.id.correct_answer);
        TextView scoreView = findViewById(R.id.score);
        Button nextBtn = findViewById(R.id.play_again_btn);
        cicleProgress ++;
        boolean is_correct = getIntent().getExtras().getBoolean("IS_CORRECT");
        if(is_correct)
        {
            backLayout.setBackgroundResource(R.drawable.correct_answer);
            nextBtn.setBackgroundResource(R.drawable.green_btn);
            message = "Yay! Correct!";
            score++;
        }
        else
        {
            backLayout.setBackgroundResource(R.drawable.wrong_answer);
            nextBtn.setBackgroundResource(R.drawable.red_btn);
            message = "Oops.. Wrong answer";
        }

        is_correct_box.setText(message);
        String correct_ans_str = getIntent().getExtras().getString("ANSWER");
        correct_answer_text.setText(correct_ans_str);

        // displaying the answer picture on the screen
        ImageView img = findViewById(R.id.ansImageView);
        Context context = img.getContext();
        int id = context.getResources().getIdentifier(correct_ans_str.toLowerCase(),
                                                "drawable", context.getPackageName());
        img.setImageResource(id);

        String performanceMetric = getPerformanceMetric();
        scoreView.setText("Score: " + performanceMetric);

        if (cicleProgress == getQuestionsAmount()) {
            nextBtn.setText("New Game!");
            nextBtn.setBackgroundResource(R.drawable.new_game_btn);
            nextBtn.setTextColor(Color.parseColor("#ffffff"));
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playAgainIntent = new Intent();
                setResult(1, playAgainIntent);
                finish();
            }
        });
    }


    @Override
    public void onBackPressed()
    {
        if (back_pressed + 2000 > System.currentTimeMillis())
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}
