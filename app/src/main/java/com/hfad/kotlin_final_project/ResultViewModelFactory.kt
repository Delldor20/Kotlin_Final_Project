package com.hfad.kotlin_final_project

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ResultViewModelFactory (private val finalResult: String, private val livesLeft: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ResultViewModel::class.java))
            return ResultViewModel(finalResult, livesLeft) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}