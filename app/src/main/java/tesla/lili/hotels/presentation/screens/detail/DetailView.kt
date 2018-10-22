package tesla.lili.hotels.presentation.screens.detail

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import tesla.lili.hotels.data.model.HotelDetail

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailView : MvpView{

    fun showHotel(hotel: HotelDetail)

}