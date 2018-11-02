package com.example.palabra;

import android.widget.ImageView;

public class Question
{
    // ###  ATTRIBUTES   ###
    private String answer_a, answer_b, answer_c, answer_d;
    //    private int points;
    private int correct_ans;
    ImageView image;


    // ###  CONSTRUCTOR   ###
    public Question(String ans1, String ans2, String ans3, String ans4, int correct)
    {
        answer_a = ans1;
        answer_b = ans2;
        answer_c = ans3;
        answer_d = ans4;
//        points = p;
        correct_ans = correct;
//        image = im;
    }


    // ###  GETTER FUNCTIONS   ###

    int getCorrectAnsInt() { return correct_ans; }

    String getCorrectAnsStr() { return getAnswer(correct_ans); }

//    public int getPoints() {  return points;  }

//    public String getAnswer_a()  {  return answer_a;  }
//
//    public String getAnswer_b()  {  return answer_b;  }
//
//    public String getAnswer_c()  {  return answer_c;  }
//
//    public String getAnswer_d()  {  return answer_d;  }

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

//    public static void setImage(ImageView im)  { image = im;  }


//    // ###  CORRECTION FUNCTIONS   ###
//
//    public boolean is_a_correct()  {  return (correct_ans == 1);  }
//
//    public boolean is_b_correct()  {  return (correct_ans == 2);  }
//
//    public boolean is_c_correct()  {  return (correct_ans == 3);  }
//
//    public boolean is_d_correct()  {  return (correct_ans == 4);  }


    static Question get_question()
    {


        return new Question("banana", "apple", "orange", "pair", 1);

    }


}
