package com.lexgorbunov.vrooms.main.di

import com.lexgorbunov.vrooms.dagger.CoreComponent
import com.lexgorbunov.vrooms.main.MainFragment
import dagger.Component
import dagger.Module

@Component(modules = [MainModule::class], dependencies = [CoreComponent::class])
interface MainComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): MainComponent
    }

    fun inject(target: MainFragment)
}

@Module
interface MainModule {

}
