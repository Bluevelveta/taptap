package com.example.taptap

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ScoreViewModelFactory(private val finalScore:Int,
                            private val finalName:String,
                            private val dataSource: ScoreDatabaseDao,
                            private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore,finalName,dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}