package tesla.lili.hotels.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tesla.lili.hotels.BuildConfig
import tesla.lili.hotels.data.api.RestApi
import java.util.concurrent.TimeUnit

class HotelRestClient {

    var hotelApi: RestApi

    init {
        val builder = OkHttpClient.Builder()
                .readTimeout(35, TimeUnit.SECONDS)
                .connectTimeout(35, TimeUnit.SECONDS)
        val client = builder
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                ))
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        hotelApi = retrofit.create(RestApi::class.java)
    }
}