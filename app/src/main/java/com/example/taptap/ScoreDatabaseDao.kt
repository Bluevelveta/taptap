package com.example.taptap

import androidx.lifecycle.LiveData

import androidx.room.Dao

import androidx.room.Insert

import androidx.room.Query

import androidx.room.Update

@Dao

interface ScoreDatabaseDao {


    @Insert

    fun insert(score: Score)



    @Update

    fun update(score: Score)



    @Query("SELECT * from score_table WHERE scoreId = :key")

    fun get(key: Long): Score?



    @Query ("SELECT * from score_table ORDER BY score DESC ")

    fun getAllScore(): LiveData<List<Score>>?

//

//    @Query ("SELECT * from score_table WHERE owner_id = :userId")

//    fun getAllScoreByUserId(userId: Long): LiveData<List<Score>>?

//

//    @Query ("SELECT * from score_table ORDER BY score DESC")

//    fun getAllScoresSortByScore(): LiveData<List<Score>>?

//

//    @Query ("SELECT * from score_table WHERE owner_id = :userId ORDER BY score DESC LIMIT 1")

//    fun getBestScoreByUserId(userId: Long): LiveData<Score>?



    @Query("DELETE FROM score_table")

    fun clear()

}