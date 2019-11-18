package com.example.taptap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore:Int,finalName:String) : ViewModel() {
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

    init {
        _score.value = finalScore
        _eventTaptap.value = false
        _eventPost.value = false

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
