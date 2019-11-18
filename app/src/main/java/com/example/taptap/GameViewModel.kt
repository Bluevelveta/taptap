package com.example.taptap

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel(finalname:String) : ViewModel() {
     val name = finalname


    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private val timer: CountDownTimer

    fun increaseScore (){
        _score.value = (_score.value)?.plus(1)
    }

    init {
        _score.value = 0
        _eventGameFinish.value = false

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/ONE_SECOND
            }
            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()
            }
        }
        timer.start()
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }


    val currentScoreString = Transformations.map(score) { score ->
        "Score : ${score}"
    }

    val currentTimerString = Transformations.map(currentTime) { time ->
        "Time : ${DateUtils.formatElapsedTime(time)}"
    }

    companion object {
        private const val DONE = 0L
        private const val ONE_SECOND = 1000L
//        private const val COUNTDOWN_TIME = 90000L
        private const val COUNTDOWN_TIME = 5000L
    }



}
