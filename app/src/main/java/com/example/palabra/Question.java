package com.example.palabra;

import android.widget.ImageView;

public class Question
{
    // ###  ATTRIBUTES   ###
    private String answer_a, answer_b, answer_c, answer_d;
    private int points;
    private int correct_ans;
    String image;


    // ###  CONSTRUCTOR   ###
    public Question(String ans1, String ans2, String ans3, String ans4, int correct, String im)
    {
        answer_a = ans1;
        answer_b = ans2;
        answer_c = ans3;
        answer_d = ans4;
//        points = p;
        correct_ans = correct;
        image = "4";
    }


    // ###  GETTER FUNCTIONS   ###

    public int getCorrect_ans() { return correct_ans; }

    public int getPoints() {  return points;  }

    public String getAnswer_a()  {  return answer_a;  }

    public String getAnswer_b()  {  return answer_b;  }

    public String getAnswer_c()  {  return answer_c;  }

    public String getAnswer_d()  {  return answer_d;  }

//    public ImageView getImage()  { return image;  }


    // ###  CORRECTION FUNCTIONS   ###

    public boolean is_a_correct()  {  return (correct_ans == 1);  }

    public boolean is_b_correct()  {  return (correct_ans == 2);  }

    public boolean is_c_correct()  {  return (correct_ans == 3);  }

    public boolean is_d_correct()  {  return (correct_ans == 4);  }


    public static Question get_question()
    {
        Question a = new Question("banana", "apple", "orange", "pair", 5, "6");
        return a;
    }




}
