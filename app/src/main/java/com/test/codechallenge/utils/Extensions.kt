package com.test.codechallenge.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


fun <T> T.asLiveData(): LiveData<T> {
    return MutableLiveData(this)
}