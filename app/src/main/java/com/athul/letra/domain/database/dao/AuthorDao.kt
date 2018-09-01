package com.athul.letra.domain.database.dao

import android.arch.persistence.room.Dao
import com.athul.letra.domain.database.BaseDao
import com.athul.letra.domain.database.tables.Author


@Dao
interface AuthorDao : BaseDao<Author> {


}