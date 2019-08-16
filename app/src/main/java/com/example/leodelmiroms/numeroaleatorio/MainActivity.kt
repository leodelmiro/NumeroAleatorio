package com.example.leodelmiroms.numeroaleatorio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*



class MainActivity : AppCompatActivity() {

    var randomNumber = Random().nextInt(10)
    lateinit var userEditText: EditText
    lateinit var mainText: TextView
    lateinit var attemptAnnouncement: TextView
    lateinit var buttonPlay: Button
    lateinit var buttonResetGame: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainText = findViewById(R.id.mainText)
        attemptAnnouncement = findViewById(R.id.annoucement)
        userEditText = findViewById(R.id.userInput)
        userEditText.inputType = InputType.TYPE_CLASS_NUMBER
        buttonPlay = findViewById(R.id.buttonPlay)
        buttonResetGame = findViewById(R.id.buttonResetGame)
    }

    fun checkNumber(randomNumber: Int, userInput: Int){
        when {
            randomNumber == userInput -> attemptAnnouncement.setText(R.string.correct_answer)
            randomNumber < userInput -> attemptAnnouncement.setText(R.string.bigger_than_answer)
            randomNumber > userInput -> attemptAnnouncement.setText(R.string.less_than_answer)
        }
    }

    fun onClickButtonPlay(view: View){
        var userInputNumber = userEditText.text.toString().toInt()
        checkNumber(randomNumber, userInputNumber)
        if (randomNumber == userInputNumber){
            userEditText.isEnabled = false
            buttonPlay.visibility = View.GONE
            buttonResetGame.visibility = View.VISIBLE
        }
    }

    fun onClickButtonResetGame(view: View){
        val intent = intent
        finish()
        overridePendingTransition(0,0)
        startActivity(intent)
    }
}
