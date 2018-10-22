package tesla.lili.hotels.presentation.di.app

import dagger.Component
import tesla.lili.hotels.presentation.screens.detail.DetailActivity
import tesla.lili.hotels.presentation.screens.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppNetworkModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)

}