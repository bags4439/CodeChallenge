package com.test.codechallenge.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.codechallenge.BuildConfig
import com.test.codechallenge.data.source.local.dao.PersonDao
import com.test.codechallenge.data.source.local.entity.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = BuildConfig.DATABASE_VERSION_CODE,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun sampleDao(): PersonDao
}