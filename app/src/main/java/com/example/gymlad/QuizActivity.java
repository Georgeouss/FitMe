package com.example.gymlad;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gymlad.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Questions questions ;
    ActivityQuizBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_quiz);
        questions = new Questions() ;
        mBinding.setQuizQuestion(questions);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questions.update();
                Toast.makeText(QuizActivity.this, "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}
