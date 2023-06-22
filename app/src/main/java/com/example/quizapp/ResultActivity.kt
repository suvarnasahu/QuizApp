package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //The code retrieves data passed from the MainActivity class through an Intent.
        // It retrieves the user's name, total number of questions, and number of correct answers.
        // It then sets the TextView elements with the user's name and the score they obtained.
        // Additionally, it checks if the user got at least 3 answers correct and displays a congratulatory message
        // if they did, or a message to try again if they didn't.
        //Finally, the code sets an OnClickListener to the Button element to start a new MainActivity when clicked.

        val username=intent.getStringExtra(Constants.USER_NAME)
        var tv_name=findViewById<TextView>(R.id.tv_name)
        var tv_score=findViewById<TextView>(R.id.tv_score)
        var btn_finish=findViewById<Button>(R.id.btn_finish)
        var tv_congratulations=findViewById<TextView>(R.id.tv_congratulations)

        tv_name.text=username

        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_score.text="Your Score is $correctAnswers out of $totalQuestions"

        if(correctAnswers>=3){
            tv_congratulations.text="Congratulations"
        } else{
            tv_congratulations.text="Better Luck Next Time"
        }

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}