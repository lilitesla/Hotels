package tesla.lili.hotels.presentation.application

import android.app.Application
import tesla.lili.hotels.presentation.di.app.AppComponent
import tesla.lili.hotels.presentation.di.app.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    var appComponent: AppComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}