package com.example.palabra;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Questions {

    public static final ArrayList<ArrayList<String>> questions;
    public static Set<Integer> questionsSet;
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

        questionsSet = new HashSet<Integer>();
    }

    static void initSet()
    {
        questionsSet.add(0);
        questionsSet.add(1);
        questionsSet.add(2);
    }

    static ArrayList<String> get_question()
    {
        if (questionsSet.size() < 1)
        {
            initSet();
        }
        Iterator<Integer> iterator = questionsSet.iterator();
        int chosenQuestionNum = iterator.next();
        copiedQuestion = questions.get(chosenQuestionNum);
        questionsSet.remove(chosenQuestionNum);
        return copiedQuestion;
    }

}
