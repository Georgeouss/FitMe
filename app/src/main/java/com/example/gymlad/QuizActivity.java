package com.example.gymlad;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gymlad.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Questions questions ;
    ActivityQuizBinding mBinding;
    private Button b1,b2,b3;
    List<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_quiz);
        questions = new Questions() ;
        mBinding.setQuizQuestion(questions);

        b1 = findViewById(R.id.button1) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.add(b1.getText().toString());
                questions.update();
            }
        });
        b2 = findViewById(R.id.button2) ;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.add(b2.getText().toString());
                questions.update();
            }
        });
        b3 = findViewById(R.id.button3) ;
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers.add(b2.getText().toString());
                questions.update();
                if(questions.getCurrentIndex()==questions.getQuestionSize())
                {
                    Intent intent = new Intent(QuizActivity.this, MeasurementsActivity.class);
                    startActivity(intent);
                }
            }
        });



    }

}
