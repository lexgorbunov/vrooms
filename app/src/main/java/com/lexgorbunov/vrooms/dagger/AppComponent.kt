package com.lexgorbunov.vrooms.dagger

import com.lexgorbunov.vrooms.App
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class], dependencies = [CoreComponent::class])
interface AppComponent {

    @Component.Factory()
    interface Factory {
        fun create(component: CoreComponent): AppComponent
    }

    fun inject(activity: App)
}


@Module
interface AppModule {

}
