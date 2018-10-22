package tesla.lili.hotels.data.model

import android.location.Location
import com.google.gson.annotations.SerializedName
import tesla.lili.hotels.presentation.application.Config


data class HotelDetail (val id: String,
                        val name: String,
                        val address: String,
                        val stars: Int,
                        val distance: Double,
                        @SerializedName("suites_availability")
                        val suitesAvailability: String,
                        val image: String,
                        val lat: Double,
                        val lon: Double
                        ) {

    fun getImageUrl(): String {
        return "https://github.com/Jokaerro/Hotello/raw/master/api/" + image
    }

    fun getFreeRoomsCount(): Int {
        return suitesAvailability.split(":").size
    }

    fun getDistanceInMetres(): Int {
        val dist = FloatArray(1)
        Location.distanceBetween(Config.centralParkNewYorkLat, Config.centralParkNewYorkLong, lat, lon, dist)
        return Math.round(dist[0])
    }

}