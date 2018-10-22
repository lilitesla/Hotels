package tesla.lili.hotels.presentation.screens.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tesla.lili.hotels.data.model.HotelDetail
import tesla.lili.hotels.data.network.HotelRestClient
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val hotelRestClient: HotelRestClient) : MvpPresenter<MainView>() {

    val hotelList = ArrayList<HotelDetail>()

    fun getHotels(){
        hotelRestClient
                .hotelApi
                .getHotels("0777.json")
                .flatMapIterable {
                    it
                }
                .flatMap {
                    hotelRestClient.hotelApi.getHotel(it.id)
                }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list: List<HotelDetail> ->
                    hotelList.addAll(list)
                    viewState.showHotels()
                }




    }



}