package tesla.lili.hotels.data.api

import io.reactivex.Observable
import tesla.lili.hotels.data.model.HotelDetail
import retrofit2.http.GET
import retrofit2.http.Path
import tesla.lili.hotels.data.model.Hotel


interface RestApi {
    @GET("lilitesla/Hotels/master/api/{source}")
    fun getHotels(@Path("source") hotelsSource: String): Observable<List<Hotel>>

    @GET("lilitesla/Hotels/master/api/{source}.json")
    fun getHotel(@Path("source") hotelSource: String): Observable<HotelDetail>
}