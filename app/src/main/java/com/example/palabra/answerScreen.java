package com.example.palabra;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class answerScreen extends AppCompatActivity {

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
        }
        else
        {
            message = "don't worry, you'll do better next time...";
        }
        is_correct_box.setText(message);

        String correct_ans_str = getIntent().getExtras().getString("ANSWER");
        //TextView correct_ans_box = findViewById(R.id.answer_text_view);
        //correct_ans_box.setText(correct_ans_str);
//        Drawable questionImage =  getResources().getDrawable(R.drawable.apple);;
//        switch (correct_ans_str)
//        {
//            case "Manzana":
//                questionImage =  getResources().getDrawable(R.drawable.manzana);
//                break;
//            case "Vaca":
//                questionImage = getResources().getDrawable(R.drawable.vaca);
//                break;
//            case "Camisa":
//                questionImage = getResources().getDrawable(R.drawable.camisa);
//                break;
//        }

        ImageView img = (ImageView)findViewById(R.id.appImageView);
        Context context = img.getContext();
        int id = context.getResources().getIdentifier(correct_ans_str.toLowerCase()+"_answer", "drawable", context.getPackageName());
        img.setImageResource(id);    // make modular in next update

        Button playAgainBtn = findViewById(R.id.play_again_btn);
        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent goToAnsScreen = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(goToAnsScreen);
                Intent playAgainIntent = new Intent();
                setResult(1, playAgainIntent);
                finish();
            }
        });

        Button exitBtn = findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitIntent = new Intent();
                setResult(0, exitIntent);
                finish();
            }
        });


    }
}
