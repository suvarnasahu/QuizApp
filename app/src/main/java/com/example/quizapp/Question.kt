package com.example.quizapp

/*
The data class is used to store information about a single quiz question,
which includes its unique identifier, the question text, an image associated with the question,
and four answer options with the index of the correct answer.
The data class automatically generates methods like equals(), hashCode(), toString(), and copy()
based on the properties defined in the class.
 */

data class Question(
    val id:Int,
    val question:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val CorrectAnswer:Int

)