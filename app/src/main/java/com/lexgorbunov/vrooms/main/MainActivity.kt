package com.lexgorbunov.vrooms.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lexgorbunov.vrooms.R
import com.lexgorbunov.vrooms.dagger.CoreComponentProvider
import com.lexgorbunov.vrooms.main.di.DaggerMainComponent
import com.lexgorbunov.vrooms.main.di.MainComponent
import com.lexgorbunov.vrooms.main.di.MainComponentProvider

class MainActivity : AppCompatActivity(),
    MainComponentProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun provideMainComponent(): MainComponent = DaggerMainComponent
        .factory()
        .create((applicationContext as CoreComponentProvider).provideCoreComponent())
}
