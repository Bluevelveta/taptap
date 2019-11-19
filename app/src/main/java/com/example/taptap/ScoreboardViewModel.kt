package com.example.taptap

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ScoreboardViewModel (database: ScoreDatabaseDao, application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var scoreList = database.getAllScore()
}
