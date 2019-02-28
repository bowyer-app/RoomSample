package com.bowyer.app.roomsample.database

import com.bowyer.app.roomsample.database.dao.AdviceDao
import com.bowyer.app.roomsample.database.entity.Advice
import com.bowyer.app.roomsample.database.entity.AdviceType
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdviceRepository @Inject constructor(
    private val adviceDao: AdviceDao
) {
    fun findAdviceList(type: AdviceType): Observable<List<Advice>> {
        return if (type == AdviceType.ALL) {
            adviceDao.getAll()
        } else {
            adviceDao.get(type == AdviceType.DONE)
        }
    }

    fun insert(advice: Advice): Long {
        return adviceDao.insert(advice)
    }

    fun update(advice: Advice): Int {
        return adviceDao.update(advice)
    }

    fun delete(advice: Advice) {
        adviceDao.delete(advice)
    }
}