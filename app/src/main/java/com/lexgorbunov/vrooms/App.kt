package com.lexgorbunov.vrooms

import android.app.Application
import com.lexgorbunov.vrooms.dagger.*

class App : Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.factory().create(this)
        DaggerAppComponent.factory().create(coreComponent).inject(this)
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}
