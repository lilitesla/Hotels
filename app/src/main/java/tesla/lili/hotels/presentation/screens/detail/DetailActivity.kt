package tesla.lili.hotels.presentation.screens.detail

import android.content.Context
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import tesla.lili.hotels.R
import javax.inject.Inject
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import tesla.lili.hotels.data.model.HotelDetail
import tesla.lili.hotels.presentation.application.App

class DetailActivity : MvpAppCompatActivity(), DetailView {

    @Inject
    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @ProvidePresenter
    fun providePresenter(): DetailPresenter {
        return presenter
    }

    companion object {
        private val HOTEL_DATA = "hotel"
        fun start(context: Context, hotelId: String) {
            val intent = Intent(context, DetailActivity::class.java)

            val bundle = Bundle()
            bundle.putString(HOTEL_DATA, hotelId)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val bundle = intent.extras
        val hotelId = bundle!!.getString(HOTEL_DATA)

        presenter.getHotel(hotelId)

    }

    override fun showHotel(hotel: HotelDetail) {

        val imageView: ImageView = findViewById(R.id.image)
        val nameView: TextView = findViewById(R.id.name)
        val textView: TextView = findViewById(R.id.text)

        var hotelName = hotel.name

        for (i in 0..hotel.stars)
            hotelName += "*"

        var hotelText = hotel.address + "\n" +
                "distance: " + hotel.getDistanceInMetres() + " m\n" +
                "available " + hotel.getFreeRoomsCount() + " suits\n"

        Picasso.get()
                .load(hotel.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .into(imageView)

        nameView.setText(hotelName)
        textView.setText(hotelText)


    }
}
