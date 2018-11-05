package com.example.palabra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Questions {

    public static final ArrayList<ArrayList<String>> questions;
    public static ArrayList<Integer> questionsNumsList;
    private static ArrayList<String> copiedQuestion;
    static
    {
        questions = new ArrayList<>(3);

        ArrayList<String> firstQuestion = new ArrayList<>();
        firstQuestion.add("Apple");
        firstQuestion.add("Manzana");
        firstQuestion.add("Naranja");
        firstQuestion.add("Durazno");
        firstQuestion.add("Piña");
        questions.add(firstQuestion);

        ArrayList<String> secondQuestion = new ArrayList<>();
        secondQuestion.add("Cow");
        secondQuestion.add("Vaca");
        secondQuestion.add("Gato");
        secondQuestion.add("Perro");
        secondQuestion.add("León");
        questions.add(secondQuestion);

        ArrayList<String> thirdQuestion = new ArrayList<>();
        thirdQuestion.add("Shirt");
        thirdQuestion.add("Camisa");
        thirdQuestion.add("Pantalón");
        thirdQuestion.add("Vestido");
        thirdQuestion.add("Falda");
        questions.add(thirdQuestion);

        questionsNumsList = new ArrayList<Integer>();
    }

    static void initSet()
    {
        questionsNumsList.add(0);
        questionsNumsList.add(1);
        questionsNumsList.add(2);
        Collections.shuffle(questionsNumsList);
    }

    static ArrayList<String> get_question()
    {
        if (questionsNumsList.size() < 1)
        {
            initSet();
        }
        int chosenQuestionNum = questionsNumsList.remove(questionsNumsList.size() - 1);

        copiedQuestion = questions.get(chosenQuestionNum);
        return copiedQuestion;
    }

}
