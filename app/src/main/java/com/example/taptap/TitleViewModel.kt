package com.example.taptap

import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {
    var name = "Unknown"

    fun setPlayer(myName:String){
        name = myName
    }
}
