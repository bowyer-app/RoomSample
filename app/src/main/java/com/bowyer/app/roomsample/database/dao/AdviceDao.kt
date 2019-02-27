package com.bowyer.app.roomsample.database.dao

import androidx.room.*
import com.bowyer.app.roomsample.database.entity.AdviceEntity
import io.reactivex.Maybe

@Dao
interface AdviceDao {

    @Query("SELECT * FROM " + AdviceEntity.TABLE)
    fun getAll(): Maybe<List<AdviceEntity>>

    @Insert
    fun insert(advice: AdviceEntity): Long

    @Update
    fun update(advice: AdviceEntity): Int

    @Delete
    fun delete(advice: AdviceEntity)
}