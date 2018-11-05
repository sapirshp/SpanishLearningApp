package com.example.palabra;

import java.util.ArrayList;
import java.util.Collections;

public class Questions {

    private static final ArrayList<ArrayList<String>> questionsList;
    private static ArrayList<Integer> questionsNumbersList;
    private static ArrayList<String> copiedQuestion;
    static
    {
        questionsList = new ArrayList<>(3);

        ArrayList<String> firstQuestion = new ArrayList<>();
        firstQuestion.add("Apple");
        firstQuestion.add("Manzana");
        firstQuestion.add("Naranja");
        firstQuestion.add("Durazno");
        firstQuestion.add("Piña");
        questionsList.add(firstQuestion);

        ArrayList<String> secondQuestion = new ArrayList<>();
        secondQuestion.add("Cow");
        secondQuestion.add("Vaca");
        secondQuestion.add("Gato");
        secondQuestion.add("Perro");
        secondQuestion.add("León");
        questionsList.add(secondQuestion);

        ArrayList<String> thirdQuestion = new ArrayList<>();
        thirdQuestion.add("Shirt");
        thirdQuestion.add("Camisa");
        thirdQuestion.add("Pantalón");
        thirdQuestion.add("Vestido");
        thirdQuestion.add("Falda");
        questionsList.add(thirdQuestion);

        ArrayList<String> fourthQuestion = new ArrayList<>();
        thirdQuestion.add("Truck");
        thirdQuestion.add("Camion");
        thirdQuestion.add("Bicicleta");
        thirdQuestion.add("Carro");
        thirdQuestion.add("Motocicleta");
        questionsList.add(fourthQuestion);

        ArrayList<String> fifthQuestion = new ArrayList<>();
        thirdQuestion.add("fireman");
        thirdQuestion.add("Bombero");
        thirdQuestion.add("Doctor");
        thirdQuestion.add("Conductor");
        thirdQuestion.add("Profesor");
        questionsList.add(fifthQuestion);

        questionsNumbersList = new ArrayList<Integer>();
    }

    private static void initSet()
    {
        for(int i = 0; i < questionsList.size(); i++)
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

        copiedQuestion = questionsList.get(chosenQuestionNum);
        return copiedQuestion;
    }

}
