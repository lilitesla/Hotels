package tesla.lili.hotels.presentation.screens.detail

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tesla.lili.hotels.data.model.HotelDetail
import tesla.lili.hotels.data.network.HotelRestClient
import javax.inject.Inject

@InjectViewState
class DetailPresenter @Inject constructor(private val hotelRestClient: HotelRestClient) : MvpPresenter<DetailView>(){

    fun getHotel(hotelId: String) {

        hotelRestClient
                .hotelApi
                .getHotel(hotelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { viewState.showHotel(it) }
    }


}