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
        ArrayList incorrectAnswers = new ArrayList();
        int correctAnswers = 0;

        if (radioQuestion1()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add("Question 1");
        }

        if (checkQuestion2()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add("Question 2");
        }

        if (editQuestion3()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add("Question 3");
        }

        if (editQuestion4()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add("Question 4");
        }

        if (radioQuestion5()) {
            correctAnswers++;
        } else {
            incorrectAnswers.add("Question 5");
        }


        if (correctAnswers == 0) {
            message = "Poor luck.\nRecheck the following:\n";
        } else if (correctAnswers == 1) {
            message = "You could do better.\nRecheck the following:\n";
        } else if (correctAnswers == 2) {
            message = "Quite nice.\nRecheck the following:\n";
        } else if (correctAnswers == 3) {
            message = "Really nice.\nRecheck the following:\n";
        } else if (correctAnswers == 4) {
            message = "Great!\nRecheck the following:\n";
        } else if (correctAnswers == 5) {
            message = "Awesome!\nYou got all correct\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object incorrect : incorrectAnswers) {
            stringBuilder.append(incorrect);
            stringBuilder.append("\n");
        }

        Toast.makeText(this, "You got " + correctAnswers + "/5 answers right.\n" + message + stringBuilder.toString(), Toast.LENGTH_LONG).show();
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
