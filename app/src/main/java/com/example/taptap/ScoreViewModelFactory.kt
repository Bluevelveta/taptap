package com.example.taptap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ScoreViewModelFactory(private val finalScore:Int,private val finalName:String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore,finalName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}