package com.test.codechallenge.ui.personal_details

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel


class PersonalDetailsFragViewModel(app: Application) : AndroidViewModel(app) {

    fun showToast() {
        Toast.makeText(getApplication(), "Go Next", Toast.LENGTH_SHORT).show()
    }
}