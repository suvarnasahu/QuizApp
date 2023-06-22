package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name" //used to store the user's name
    const val TOTAL_QUESTION:String="total_question" //used to store the total number of questions in the quiz.
    const val CORRECT_ANSWERS:String="correct_answers" //used to store the number of questions the user answered correctly.

    /*The getQuestions() function initializes an ArrayList of Question objects with the necessary data for quiz.
     Each Question object contains a unique ID, a question string, an associated image,
     four answer options, and the index of the correct answer.
     The function then returns the ArrayList of Question objects.
     */

    fun getQuestions():ArrayList<Question>{

        val questionList=ArrayList<Question>()

        val ques1=Question(
            1,
            "Which place is this in BSU?",
            R.drawable.boydenhall,
            "BOYDEN HALL",
            "CRIMSON HALL",
            "RSU",
            "ECC",
            1
        )
        questionList.add(ques1)

        val ques2=Question(
            2,
            "Which place is this in BSU?",
            R.drawable.cabin,
            "Dr. JOHN SANTORE OFFICE",
            "Dr. SEIKYUNG JUNG OFFICE",
            "DR. PAUL KIM OFFICE",
            "DR. HALEH KHOJASTEH OFFICE",
            2
        )
        questionList.add(ques2)

        val ques3=Question(
            3,
            "Which place is this in BSU?",
            R.drawable.dmf,
            "KELLY GYMNASIUM",
            "CRIMSON HALL",
            "DMF",
            "ECC",
            3
        )
        questionList.add(ques3)

        val ques4=Question(
            4,
            "Which place is this in BSU?",
            R.drawable.moakley,
            "WELCOME CENTER",
            "CRIMSON HALL",
            "RSU",
            "MOAKLEY BUILDING",
            4
        )
        questionList.add(ques4)

        val ques5=Question(
            5,
            "Which place is this in BSU?",
            R.drawable.rsucafe,
            "BOYDEN HALL",
            "CRIMSON HALL",
            "RSU",
            "ECC",
            3
        )
        questionList.add(ques5)

        val ques6=Question(
            6,
            "Which place is this in BSU?",
            R.drawable.universitypark,
            "WEST PARKING LOT",
            "UNIVERSITY PARK",
            "MOAKLEY",
            "ECC",
            2
        )
        questionList.add(ques6)

        val ques7=Question(
            7,
            "Which place is this in BSU?",
            R.drawable.maxwelllibrary,
            "GATES OFFICE",
            "CRIMSON HALL",
            "MAXWELL LIBRARY",
            "ECC",
            3
        )
        questionList.add(ques7)

        val ques8=Question(
            8,
            "Which place is this in BSU?",
            R.drawable.ecc,
            "BOYDEN HALL",
            "CRIMSON HALL",
            "RSU",
            "ECC",
            4
        )
        questionList.add(ques8)

        val ques9=Question(
            9,
            "Which place is this in BSU?",
            R.drawable.operationscenter,
            "RSU",
            "WEYGAND HALL",
            "BSU OPERATIONS CENTER",
            "ECC",
            3
        )
        questionList.add(ques9)

        val ques10=Question(
            10,
            "Which place is this in BSU?",
            R.drawable.adriantinsleycenter,
            "ADRIAN TINSLEY CENTER",
            "CRIMSON HALL",
            "RSU",
            "ECC",
            1
        )
        questionList.add(ques10)



        return questionList


    }
}