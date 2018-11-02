package com.example.palabra;

import android.widget.ImageView;

public class Question
{
    // ###  ATTRIBUTES   ###
    private String answer_a, answer_b, answer_c, answer_d;
    private int correct_ans;
    ImageView image;

    // ###  CONSTRUCTOR   ###
    public Question(String ans1, String ans2, String ans3, String ans4, int correct)
    {
        answer_a = ans1;
        answer_b = ans2;
        answer_c = ans3;
        answer_d = ans4;
        correct_ans = correct;
    }

    // ###  GETTER FUNCTIONS   ###
    int getCorrectAnsInt() { return correct_ans; }
    String getCorrectAnsStr() { return getAnswer(correct_ans); }

    public String getAnswer(int choice)
    {
        String answer = "fffff";
        switch (choice){
            case 1: answer =  answer_a;
                break;
            case 2: answer = answer_b;
                break;
            case 3: answer = answer_c;
                break;
            case 4: answer = answer_d;
                break;
        }
        return answer;
    }

    static Question get_question()
    {
        return new Question("banana", "apple", "orange", "pair", 1);
    }
}
