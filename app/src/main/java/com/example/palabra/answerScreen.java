package com.example.palabra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.palabra.QuestionsDB.getQuestionsAmount;
import static com.example.palabra.QuestionsDB.score;


public class answerScreen extends AppCompatActivity {

    private static long back_pressed;

    public static String getPerformanceMetric() {
        return String.valueOf(score) + "/" + String.valueOf(getQuestionsAmount());
    }

//    list of 2 ints instead of string
//    public static int[] getPerformanceMetric() {
//        return new int[] {score, getQuestionsAmount()};
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_screen);

        String message;
        TextView is_correct_box = findViewById(R.id.is_correct_text_view);
        boolean is_correct = getIntent().getExtras().getBoolean("IS_CORRECT");
        if(is_correct)
        {
            message = "yay! correct!";
            score++;
        }
        else
        {
            message = "don't worry, you'll do better next time...";
        }
        is_correct_box.setText(message);
        String correct_ans_str = getIntent().getExtras().getString("ANSWER");

        // displaying the answer picture on the screen
        ImageView img = findViewById(R.id.ansImageView);
        Context context = img.getContext();
        int id = context.getResources().getIdentifier(correct_ans_str.toLowerCase()+"_answer", "drawable", context.getPackageName());
        img.setImageResource(id);

        String performanceMetric = getPerformanceMetric(); //TODO use in the new score bar

//        list of 2 ints instead of string
//        int[] performanceMetric = getPerformanceMetric();


        Button playAgainBtn = findViewById(R.id.play_again_btn);
        playAgainBtn.setOnClickListener(new View.OnClickListener() {
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
