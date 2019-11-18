package com.example.taptap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class GameViewModelFactory(private val finalName:String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(finalName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}