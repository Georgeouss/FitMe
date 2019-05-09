package com.example.gymlad;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

public class Questions extends BaseObservable {
    private List<String> questions;
    private List<Choice> choices = new ArrayList<>();
    private int currentIndex ;

    public Questions() {
        questions = new ArrayList<>() ;
        questions.add("You are : ");
        choices.add(new Choice("Male", "Female"));
        questions.add("Your goal is : ") ;
        choices.add(new Choice("Gain weight", "Maintain weight" ,"Lose weight"));
        currentIndex = 0 ;
    }

    @Bindable
    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getQuestionSize() {
        return questions.size();
    }


    public void update() {
        ++this.currentIndex;
    }

    @Bindable
    public  String getChoice1() {
        return choices.get(currentIndex).getChoice1();
    }
    @Bindable
    public String getChoice2() {
        return choices.get(currentIndex).getChoice2();
    }
    @Bindable
    public String getChoice3() {
        return choices.get(currentIndex).getChoice3();
    }
    @Bindable
    public String getQuestions() {
        return questions.get(currentIndex);
    }

    private class Choice {
        String choice1;
        String choice2;
        String choice3;

        public Choice(String choice1, String choice2) {
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = "";
        }

        public Choice(String choice1, String choice2, String choice3) {
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = choice3;
        }

        public String getChoice1() {
            return choice1;
        }

        public String getChoice2() {
            return choice2;
        }

        public String getChoice3() {
            return choice3;
        }
    }
}