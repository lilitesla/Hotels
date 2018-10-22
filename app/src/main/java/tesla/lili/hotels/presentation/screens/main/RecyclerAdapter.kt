package tesla.lili.hotels.presentation.screens.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import tesla.lili.hotels.R
import tesla.lili.hotels.data.model.HotelDetail
import android.widget.Toast
import tesla.lili.hotels.presentation.screens.detail.DetailActivity


class RecyclerAdapter (val hotelList: List<HotelDetail>, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.name)
        val text: TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hotel_card, p0, false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

        var hotelName = hotelList[pos].name

        for (i in 0..hotelList[pos].stars)
            hotelName += "*"

        var hotelText = hotelList[pos].address + "\n" +
                "distance: " + hotelList[pos].distance + " m\n" +
                "available " + hotelList[pos].getFreeRoomsCount() + " suits"

        Picasso.get()
                .load(hotelList[pos].getImageUrl())
                .placeholder(R.drawable.placeholder)
                .into(holder.image)
        holder.name.setText(hotelName)
        holder.text.setText(hotelText)

        holder.itemView.setOnClickListener {
            DetailActivity.start(context, hotelList[pos].id)
        }

    }




}