package com.test.codechallenge.di

import com.test.codechallenge.data.source.repository.PersonRepository
import com.test.codechallenge.data.source.repository.PersonRepositoryImpl
import org.koin.dsl.module


val repositoriesModule = module {
    factory<PersonRepository> { PersonRepositoryImpl(get(), get()) }
}