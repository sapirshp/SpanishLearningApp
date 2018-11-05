package com.example.palabra;

import android.widget.ImageView;

import java.util.ArrayList;

public class Question
{
    // ###  ATTRIBUTES   ###
    private String englishWord, answer_a, answer_b, answer_c, answer_d;
    private int correct_ans;
    ImageView image;

    // ###  CONSTRUCTOR   ###
    public Question(String toTranslate, String ans1, String ans2, String ans3, String ans4, int correct)
    {
        englishWord = toTranslate;
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
        String answer = "answer_a";
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
        ArrayList<String> question = QuestionsDB.get_question();
        return new Question(question.get(0), question.get(1), question.get(2), question.get(3),
                            question.get(4), 1);
    }
}

