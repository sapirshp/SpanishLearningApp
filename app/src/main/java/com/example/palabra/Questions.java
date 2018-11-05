package com.example.palabra;

import java.util.ArrayList;
import java.util.Collections;

public class Questions {

    private static final ArrayList<ArrayList<String>> questions;
    private static ArrayList<Integer> questionsNumbersList;
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

//        ArrayList<String> fourthQuestion = new ArrayList<>();
//        thirdQuestion.add("Truck");
//        thirdQuestion.add("Camión");
//        thirdQuestion.add("Bicicleta");
//        thirdQuestion.add("Carro");
//        thirdQuestion.add("Motocicleta");
//        questions.add(thirdQuestion);
//
//        ArrayList<String> fifthQuestion = new ArrayList<>();
//        thirdQuestion.add("fireman");
//        thirdQuestion.add("Bombero");
//        thirdQuestion.add("Doctor");
//        thirdQuestion.add("Conductor");
//        thirdQuestion.add("Profesor");
//        questions.add(thirdQuestion);

        questionsNumbersList = new ArrayList<Integer>();
    }

    private static void initSet()
    {
        for(int i = 0; i < questions.size(); i++)
        {
            questionsNumbersList.add(i);
        }
        Collections.shuffle(questionsNumbersList);
    }

    static ArrayList<String> get_question()
    {
        if (questionsNumbersList.size() < 1)
        {
            initSet();
        }
        int chosenQuestionNum = questionsNumbersList.remove(questionsNumbersList.size() - 1);

        copiedQuestion = questions.get(chosenQuestionNum);
        return copiedQuestion;
    }

}
