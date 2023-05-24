package com.test.codechallenge.di

import com.test.codechallenge.ui.personal_details.PersonalDetailsFragViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelsModule = module {
    viewModel { PersonalDetailsFragViewModel(get()) }
}