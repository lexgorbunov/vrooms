package com.lexgorbunov.vrooms.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(modules = [CoreModule::class])
interface CoreComponent {

    @Component.Factory()
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }
}


@Module
interface CoreModule {

}
