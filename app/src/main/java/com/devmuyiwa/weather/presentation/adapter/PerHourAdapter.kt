package com.devmuyiwa.weather.presentation.adapter

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.devmuyiwa.weather.R
import com.devmuyiwa.weather.presentation.helper.PerHourHelper
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PerHourAdapter(private val listOfHourlyWeather: ArrayList<PerHourHelper>) : RecyclerView
.Adapter<PerHourAdapter.MyViewHolder>
    () {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var time: TextView = itemView.findViewById(R.id.tv_time)
        var weatherIcon: ImageView = itemView.findViewById(R.id.iv_icon)
        var temperature: TextView = itemView.findViewById(R.id.tv_temperature)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout
            .layout_hourly_forecast_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listOfHourlyWeather[position]
        holder.time.text = getTimeFromString(data.time)
        // use glide or coil to load the image from url
        holder.weatherIcon.load("https:${ data.icon }"){placeholder(R.drawable
            .ic_launcher_background)}
        holder.temperature.text = "${data.temperature}°"
    }

    override fun getItemCount(): Int = listOfHourlyWeather.size

    private fun getTimeFromString(time: String): String {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val localDateTime = LocalDateTime.parse(time, pattern)
        val localTime = localDateTime.toLocalTime()
        return localTime.toString()
    }
}