package com.example.taptap

import android.os.Parcelable

import androidx.room.ColumnInfo

import androidx.room.Entity

import androidx.room.PrimaryKey

import kotlinx.android.parcel.Parcelize



@Parcelize

@Entity(tableName = "score_table")

data class Score(

    @PrimaryKey(autoGenerate = true)

    var scoreId: Long = 0L,

    @ColumnInfo(name = "name")

    var name: String ="",

    @ColumnInfo(name = "score")

    var score: Int = -1



) : Parcelable {



}