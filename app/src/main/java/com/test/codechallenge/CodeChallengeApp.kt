package com.test.codechallenge

import android.app.Application
import com.test.codechallenge.di.appComponents
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CodeChallengeApp : Application(){
    override fun onCreate() {
        super.onCreate()

        configureDI()
    }

    private fun configureDI() {
        startKoin {
            androidLogger()
            androidContext(this@CodeChallengeApp)
            modules(provideComponents())
        }
    }

    private fun provideComponents() = appComponents
}