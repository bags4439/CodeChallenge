package com.test.codechallenge.data.source.local.dao

import androidx.room.Dao
import com.test.codechallenge.data.source.local.entity.PersonEntity


@Dao
interface PersonDao : BaseDao<PersonEntity>