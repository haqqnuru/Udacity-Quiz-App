package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // called when submit is clicked

    public void submitQuiz(View view) {
        String message = null;

        // check and calculate answers
        ArrayList incorrectAnswers = new ArrayList();
        int correctAnswers = 0;

        if (radioQuestion1()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.java1));
        }

        if (checkQuestion2()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav2));
        }

        if (editQuestion3()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav3));
        }

        if (editQuestion4()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav4));
        }

        if (radioQuestion5()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add(getString(R.string.jav5));
        }

      // grading quiz
        if (correctAnswers == 0) {
            message = getString(R.string.message1);
        } else if (correctAnswers == 1) {
            message = getString(R.string.message2);
        } else if (correctAnswers == 2) {
            message = getString(R.string.message3);
        } else if (correctAnswers == 3) {
            message = getString(R.string.message4);
        } else if (correctAnswers == 4) {
            message = getString(R.string.message5);
        } else if (correctAnswers == 5) {
            message = getString(R.string.message6);
        }

        // shows or echos which questions where not answered correctly
        StringBuilder stringBuilder = new StringBuilder();
        for (Object incorrect : incorrectAnswers) {
            stringBuilder.append(incorrect);
            stringBuilder.append("\n");
        }

        Toast.makeText(this, getString(R.string.toast1) +" "+ correctAnswers + getString(R.string.toast2) + message + stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }


// question 1

    private boolean radioQuestion1() {
        RadioGroup ques1 = (RadioGroup) findViewById(R.id.qustion1);
        if (ques1.getCheckedRadioButtonId() == R.id.ranswer2) {
            return true;
        } else {
            return false;
        }
    }


    // question2

    private boolean checkQuestion2() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.mahama);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.kuffour);

        if (checkBox.isChecked() && checkBox1.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    // question 3

    private boolean editQuestion3() {

        EditText editText = (EditText) findViewById(R.id.edit1);

        return editText.getText().toString().equalsIgnoreCase("Gold Coast");
    }


    // question 4

    private boolean editQuestion4() {

        EditText editText = (EditText) findViewById(R.id.edit2);

        return editText.getText().toString().equalsIgnoreCase("Cedi");
    }


    // question 5
    private boolean radioQuestion5() {
        RadioGroup ques1 = (RadioGroup) findViewById(R.id.qustion5);
        if (ques1.getCheckedRadioButtonId() == R.id.ranswer8) {
            return true;
        } else {
            return false;
        }
    }

    // reset
    public void reset(View view) {

        RadioGroup radioGroup = findViewById(R.id.qustion1);
        radioGroup.clearCheck();
        CheckBox checkBox = findViewById(R.id.mahama);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.kuffour);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.kusi);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.mensah);
        checkBox.setChecked(false);
        EditText editText = findViewById(R.id.edit1);
        editText.setText("");
        RadioGroup radioGroup2 = findViewById(R.id.qustion5);
        radioGroup2.clearCheck();
        EditText editText2 = findViewById(R.id.edit2);
        editText2.setText("");

    }
}
