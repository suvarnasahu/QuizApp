package com.example.quizapp

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*When the start button is clicked, an OnClickListener is triggered.
        This listener first checks if the user has entered a name in the TextView. If the TextView is empty,
        a message is displayed asking the user to enter their name.
        If a name has been entered,an Intent is created to start the QuizQuestionsActivity activity.
        The user's name is added as an extra to the Intent using the putExtra() method and the Constants.
        USER_NAME constant defined in another class.
        Finally, the QuizQuestionsActivity activity is started and the current activity is finished.*/

        var start_button=findViewById<Button>(R.id.btn_start)
        var name=findViewById<TextView>(R.id.edit_text)



        start_button.setOnClickListener {
            if(name.text.toString().isEmpty()){
                Toast.makeText(this,
                    "please enter your name",Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}