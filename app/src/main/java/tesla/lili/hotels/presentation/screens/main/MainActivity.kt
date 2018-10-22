package tesla.lili.hotels.presentation.screens.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import tesla.lili.hotels.R
import tesla.lili.hotels.presentation.application.App
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        presenter.getHotels()
    }

    override fun showHotels() {
        val hotelRecycler = findViewById<RecyclerView>(R.id.hotel_recycler)
        val recyclerAdapter = RecyclerAdapter(presenter.hotelList, this)
        val layoutManager = GridLayoutManager(this, 2)

        hotelRecycler.adapter = recyclerAdapter
        hotelRecycler.layoutManager = layoutManager
    }

}
