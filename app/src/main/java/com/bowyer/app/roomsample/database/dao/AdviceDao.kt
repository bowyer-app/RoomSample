package com.bowyer.app.roomsample.database.dao

import androidx.room.*
import com.bowyer.app.roomsample.database.entity.Advice
import io.reactivex.Observable

@Dao
interface AdviceDao {

    @Query("SELECT * FROM " + Advice.TABLE)
    fun getAll(): Observable<List<Advice>>

    @Query("SELECT * FROM ${Advice.TABLE} WHERE done = :isDone")
    fun get(isDone: Boolean): Observable<List<Advice>>

    @Insert
    fun insert(advice: Advice): Long

    @Update
    fun update(advice: Advice): Int

    @Delete
    fun delete(advice: Advice)
}