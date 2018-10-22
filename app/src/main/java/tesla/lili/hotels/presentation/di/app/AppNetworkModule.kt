package tesla.lili.hotels.presentation.di.app

import dagger.Module
import dagger.Provides
import tesla.lili.hotels.data.network.HotelRestClient
import javax.inject.Singleton

@Module
class AppNetworkModule {

    @Provides
    @Singleton
    fun provideHotelRestClient(): HotelRestClient {
        return HotelRestClient()
    }

}