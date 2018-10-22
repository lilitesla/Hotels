package tesla.lili.hotels.data.model

import com.google.gson.annotations.SerializedName

data class Hotel (val id: String,
                  val name: String,
                  val address: String,
                  val stars: Int,
                  val distance: Double,
                  @SerializedName("suites_availability")
                  val suitesAvailability: String) {

}