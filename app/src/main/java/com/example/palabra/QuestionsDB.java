package com.example.palabra;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionsDB {

    private static final ArrayList<ArrayList<String>> questionsList;
    private static ArrayList<Integer> questionsNumbersList;
    public static int score;
    public static int cicleProgress;
    static {
        questionsList = new ArrayList<>();

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
        fourthQuestion.add("Truck");
        fourthQuestion.add("Camion");
        fourthQuestion.add("Bicicleta");
        fourthQuestion.add("Carro");
        fourthQuestion.add("Motocicleta");
        questionsList.add(fourthQuestion);

        ArrayList<String> fifthQuestion = new ArrayList<>();
        fifthQuestion.add("fireman");
        fifthQuestion.add("Bombero");
        fifthQuestion.add("Doctor");
        fifthQuestion.add("Conductor");
        fifthQuestion.add("Profesor");
        questionsList.add(fifthQuestion);

        questionsNumbersList = new ArrayList<Integer>();
        score = 0;
    }

    private static void initValues() {
        for(int i = 0; i < questionsList.size(); i++) {
            questionsNumbersList.add(i);
        }
        Collections.shuffle(questionsNumbersList);
        score = 0;
        cicleProgress = 0;
    }

    static ArrayList<String> get_question() {
        if (questionsNumbersList.size() < 1) {
            initValues();
        }
        int chosenQuestionNum = questionsNumbersList.remove(questionsNumbersList.size() - 1);
        return questionsList.get(chosenQuestionNum);
    }

    public static int getQuestionsAmount() {
        return questionsList.size();
    }

}
