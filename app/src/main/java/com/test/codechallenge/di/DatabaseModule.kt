package com.test.codechallenge.di

import androidx.room.Room
import com.test.codechallenge.BuildConfig
import com.test.codechallenge.data.source.local.AppDatabase
import org.koin.dsl.module


val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, BuildConfig.DATABASE_NAME)
            .build()
    }

    single { get<AppDatabase>().sampleDao() }
}