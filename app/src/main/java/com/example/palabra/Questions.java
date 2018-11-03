package com.example.palabra;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Random;

public class Questions {

    public static final SparseArray<ArrayList<String>> questions;
    static
    {
        questions = new SparseArray<>(3);

        ArrayList<String> firstQuestion = new ArrayList<>();
        firstQuestion.add("Apple");
        firstQuestion.add("Manzana");
        firstQuestion.add("Naranja");
        firstQuestion.add("Durazno");
        firstQuestion.add("Piña");
        questions.put(1, firstQuestion);

        ArrayList<String> secondQuestion = new ArrayList<>();
        secondQuestion.add("Cow");
        secondQuestion.add("Vaca");
        secondQuestion.add("Gato");
        secondQuestion.add("Perro");
        secondQuestion.add("León");
        questions.put(2, secondQuestion);

        ArrayList<String> thirdQuestion = new ArrayList<>();
        thirdQuestion.add("Shirt");
        thirdQuestion.add("Camisa");
        thirdQuestion.add("Pantalón");
        thirdQuestion.add("Vestido");
        thirdQuestion.add("Falda");
        questions.put(3, thirdQuestion);
    }

    static ArrayList<String> get_question()
    {
        Random random = new Random();
        int randomNumber = random.nextInt((questions.size() + 1));
        return questions.get(randomNumber);
    }

}
