package com.example.palabra;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question
{
    // ###  ATTRIBUTES   ###
    private String englishWord, correct_answer, answer_a, answer_b, answer_c, answer_d;
    private int answer_number;
    ImageView image;

    private int findRightAnswer(ArrayList<String> answers) {
        int i = 0;
        while ((i < answers.size()) && !(answers.get(i).equals(correct_answer))) { i++; }
        return i;
    }

    // ###  CONSTRUCTOR   ###
    private Question(String toTranslate, ArrayList<String> answers) {
        englishWord = toTranslate;
        correct_answer = answers.get(0);
        Collections.shuffle(answers);
        answer_a = answers.get(0);
        answer_b = answers.get(1);
        answer_c = answers.get(2);
        answer_d = answers.get(3);
        answer_number = findRightAnswer(answers);
    }

    // ###  GETTER FUNCTIONS   ###
    int getCorrectAnsInt() { return answer_number; }
    String getCorrectAnsStr() { return correct_answer; }

    public String getAnswer(int choice) {
        String answer = "";
        switch (choice){
            case 0: answer = answer_a;
                break;
            case 1: answer = answer_b;
                break;
            case 2: answer = answer_c;
                break;
            case 3: answer = answer_d;
                break;
        }
        return answer;
    }

    static Question get_question() {
        ArrayList<String> question = QuestionsDB.get_question();
        String toTranslate = question.get(0);
        ArrayList<String> answers = new ArrayList<>(
                Arrays.asList(question.get(1), question.get(2), question.get(3), question.get(4)));
        return new Question(toTranslate, answers);
    }
}

