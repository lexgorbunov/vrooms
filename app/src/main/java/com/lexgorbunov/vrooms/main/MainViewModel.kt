package com.lexgorbunov.vrooms.main

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    fun log(message: String) {
        Log.d("TEST", message)
    }
}
