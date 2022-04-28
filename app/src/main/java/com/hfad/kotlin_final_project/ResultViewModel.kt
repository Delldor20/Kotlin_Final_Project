package com.hfad.kotlin_final_project

import androidx.lifecycle.ViewModel

class ResultViewModel(finalResult: String, livesLeft: Int) : ViewModel() {
    val lives = livesLeft
    val result = finalResult
}