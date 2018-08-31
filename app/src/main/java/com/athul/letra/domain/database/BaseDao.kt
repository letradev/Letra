package com.athul.letra.domain.database

import android.arch.persistence.room.*

/**
 * Created by  on 18-04-2018.
 */
@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insert(type: T): Long

    @Update
    @JvmSuppressWildcards
    abstract fun update(type: T)

    @Delete
    @JvmSuppressWildcards
    abstract fun delete(type: T)
}