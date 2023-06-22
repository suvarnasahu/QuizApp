package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    /*It initializes variables to keep track of the current question position,
    the list of questions,the option selected by the user, the number of correct answers, and the user name.*/

    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers:Int=0
    private var mUserName:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList=Constants.getQuestions()

        setQuestion()

        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        var btn_submit=findViewById<Button>(R.id.Submit)

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)



    }

    private fun setQuestion(){

        //The setQuestion() function is used to set the current question and options,
        // and it also updates the progress bar and the question number.

        var submit=findViewById<Button>(R.id.Submit)
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition==mQuestionsList!!.size){
            submit.text="FINISH"
        }else{
            submit.text="SUBMIT"
        }

        var progressBar=findViewById<ProgressBar>(R.id.progressBar)
        var tv_progress=findViewById<TextView>(R.id.tv_progress)
        var tv_question=findViewById<TextView>(R.id.tv_question)
        var iv_image=findViewById<ImageView>(R.id.iv_image)
        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)

        progressBar.progress=mCurrentPosition
        tv_progress.text="$mCurrentPosition" + "/" +progressBar.max
        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour

    }

    private fun defaultOptionsView(){

        //The defaultOptionsView() function sets the default view of the options before any user interaction.

        val options=ArrayList<TextView>()
        var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(p0: View?) {

        //The onClick() function is used to handle user clicks on the options and submit button.
        // When an option is clicked, it changes the view of the option, and when the submit button is clicked,
        // it checks if the selected option is correct or not and updates the score accordingly.
        // If there are more questions, it loads the next question,
        // and if there are no more questions, it goes to the result activity.
        when(p0?.id){

            R.id.tv_option_one->{
                selectedOptionView(p0 as TextView,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(p0 as TextView,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(p0 as TextView,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(p0 as TextView,4)
            }
            R.id.Submit->{
                if (mSelectedOptionPosition==0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }else ->{
                            val intent=Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTION,mQuestionsList!!.size)
                        startActivity(intent)

                            //Toast.makeText(this, "You have successfully completed the Quiz",Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    var submit=findViewById<Button>(R.id.Submit)
                    if(question!!.CorrectAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.CorrectAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        submit.text="FINISH"
                    }else{
                        submit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }

            }

        }

    }
    private fun answerView(answer:Int,drawableView:Int){

        //answerview function changes the background drawable of a TextView based on the value of the answer parameter.
        //It takes two parameters:
        //answer: an integer value that represents the answer option. It can have the values 1, 2, 3, or 4.
        //drawableView: an integer value that represents the drawable resource
        // that will be used as the background of the TextView.
        //Inside the function, there is a when expression that checks the value of answer
        // and sets the background drawable of the corresponding TextView accordingly. If answer is 1,
        // the background drawable of tv_option_one TextView will be set, if answer is 2,
        // tv_option_two will be set, and so on.
        //the setBackgroundDrawable method is used to set the drawable as the background of the TextView.
        when(answer){
            1->{
                var tv_option_one=findViewById<TextView>(R.id.tv_option_one)
                tv_option_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                var tv_option_two=findViewById<TextView>(R.id.tv_option_two)
                tv_option_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                var tv_option_three=findViewById<TextView>(R.id.tv_option_three)
                tv_option_three.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                var tv_option_four=findViewById<TextView>(R.id.tv_option_four)
                tv_option_four.background=ContextCompat.getDrawable(this,drawableView)
            }

        }
    }



    private fun selectedOptionView(tv:TextView,
                                   selectedOptionNum:Int){
        //This is a function that sets the view of the selected answer option in a quiz application.
        //It takes two parameters: a TextView object and an integer that represents the selected option number.
        //First, the function calls the defaultOptionsView() function, which resets the view of all the answer
        //options to the default state.
        //Then, the function sets the mSelectedOptionPosition variable to the selected option number.
        //This variable is used to keep track of the user's selected answer.
        //Next, the function changes the text color of the selected TextView object to a darker color
        //and sets its typeface to bold.
        //It also sets a drawable as the background of the TextView object to highlight the selected option.


        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)



    }
}