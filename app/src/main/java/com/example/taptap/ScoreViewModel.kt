package com.example.taptap

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ScoreViewModel(finalScore:Int,finalName:String, val database: ScoreDatabaseDao,application: Application) : AndroidViewModel(application)  {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventPost = MutableLiveData<Boolean>()
    val eventPost: LiveData<Boolean>
        get() = _eventPost

    private val _eventTaptap = MutableLiveData<Boolean>()
    val eventTaptap: LiveData<Boolean>
        get() = _eventTaptap

    val nameString = finalName

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        _score.value = finalScore
        _eventTaptap.value = false
        _eventPost.value = false

        uiScope.launch {
            storeScore(finalName, finalScore)
        }

    }

    private suspend fun storeScore(name: String, score: Int) {
        return withContext(Dispatchers.IO) {
            val newScore = Score()
            newScore.name = name
            newScore.score = score
            database.insert(newScore)
//            database.clear()
        }

    }

    fun onRetry() {
        _eventTaptap.value = true
    }
    fun onPost() {
        _eventPost.value = true
    }
    fun onPostinComplete() {
        _eventPost.value = false
    }
}
