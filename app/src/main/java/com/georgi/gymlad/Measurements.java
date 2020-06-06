package com.georgi.gymlad;//package com.example.gymlad;
//
//import android.databinding.BaseObservable;
//import android.databinding.Bindable;
//import android.view.View;
//
//public class Measurements extends BaseObservable {
//    private String age;
//    private String height;
//    private String currentWeight;
//    private String goalWeight;
//
//    public Measurements(){
//        this.age = "";
//        this.height = "";
//        this.currentWeight = "";
//        this.goalWeight = "";
//
//    }
//    @Bindable
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//        notifyPropertyChanged(BR.buttonDisabled);
//    }
//    @Bindable
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//        notifyPropertyChanged(BR.buttonDisabled);
//    }
//    @Bindable
//    public String getCurrentWeight() {
//        return currentWeight;
//    }
//
//    public void setCurrentWeight(String currentWeight) {
//        this.currentWeight = currentWeight;
//        notifyPropertyChanged(BR.buttonDisabled);
//    }
//    @Bindable
//    public String getGoalWeight() {
//        return goalWeight;
//    }
//
//    public void setGoalWeight(String goalWeight) {
//        this.goalWeight = goalWeight;
//        notifyPropertyChanged(BR.buttonDisabled);
//    }
//
//    @Bindable
//   public boolean isButtonDisabled(){
//        return this.age.equals("") || this.height.equals("") ||
//                this.currentWeight.equals("") || this.goalWeight.equals("");
//    }
//}
