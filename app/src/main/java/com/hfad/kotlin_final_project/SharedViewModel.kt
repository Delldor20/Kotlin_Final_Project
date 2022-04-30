package com.hfad.kotlin_final_project

import android.app.Application
import android.widget.ArrayAdapter
import androidx.lifecycle.AndroidViewModel

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    val resources = getApplication<Application>().resources
    val wordsList = resources.getStringArray(R.array.wordsList)
    val word = wordsList.random().uppercase()
    var wordDisplay = ""
    var correctGuesses = ""
    var incorrectGuesses = ""
    var lives = 10

    init{
        wordDisplay = deriveWordDisplay()
    }

    fun isWon() : Boolean
    {
        return word.equals(wordDisplay, true)
    }

    fun isLost() : Boolean
    {
        return lives <= 0
    }

    fun wonLostMessage() : String
    {
        var message = ""
        if(isWon()) {
            message = "You won with $lives Lives Remaining!"
        } else if (isLost()) {
            message = "You lost with $lives Lives Remaining! \n"
            message += " The word was $word"
        }
        return message
    }

    fun checkLetter(str: String) = when(correctGuesses.contains(str)) {
            true -> str
            false -> "_"
    }

    fun deriveWordDisplay() : String {
        var display = ""
        word.forEach {
            display += checkLetter(it.toString())
        }
        return display
    }

    fun makeGuess(guess: String)
    {
        if(word.contains(guess)) {
            correctGuesses += guess
            wordDisplay = deriveWordDisplay()
        } else if(!incorrectGuesses.contains(guess)){
            incorrectGuesses += "$guess"
            lives--
        }
    }
}