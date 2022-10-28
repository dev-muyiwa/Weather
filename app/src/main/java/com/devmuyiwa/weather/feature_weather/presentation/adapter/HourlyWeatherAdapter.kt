package com.devmuyiwa.weather.feature_weather.presentation.adapter

import android.content.*
import android.view.*
import android.view.ViewGroup.*
import androidx.recyclerview.widget.*
import coil.*
import com.devmuyiwa.weather.databinding.*
import com.devmuyiwa.weather.feature_weather.presentation.helper.*
import com.devmuyiwa.weather.feature_weather.util.*
import java.time.*

class HourlyWeatherAdapter(private val context: Context) :
	ListAdapter<UIHourlyForecast, HourlyWeatherAdapter.MyViewHolder>(ITEM_COMPARATOR) {
	inner class MyViewHolder(private val binding: LayoutHourlyForecastItemBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bindItem(item: UIHourlyForecast) {
			val params: MarginLayoutParams = binding.hourTime.layoutParams as MarginLayoutParams
			val params2: MarginLayoutParams =
				binding.linearLayout.layoutParams as MarginLayoutParams
			binding.hourTime.text = item.time
			binding.weatherIcon.load(item.icon) // add error drawable
			binding.hourTemperature.text = item.temperature
			if (item.time == LocalTime.now().to12HourFormat()) {
				binding.hourTemperature.isActivated = true
				binding.hourTime.isActivated = true
				binding.linearLayout.scaleX = 1f
				binding.linearLayout.scaleY = 1f
				binding.hourTime.scaleY = 1f
				binding.hourTime.scaleX = 1f
				params.topMargin = - 5
				params.bottomMargin = 10
				binding.linearLayout.isActivated = true
			} else {
				binding.linearLayout.scaleX = 0.9f
				binding.linearLayout.scaleY = 0.9f
				binding.hourTime.scaleX = 0.9f
				params.topMargin = 2
				params.bottomMargin = 2
				binding.hourTime.scaleY = 0.9f
				binding.hourTime.isActivated = false
				binding.hourTemperature.isActivated = false
				binding.linearLayout.isActivated = false
			}
		}

	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		val view = LayoutHourlyForecastItemBinding
			.inflate(LayoutInflater.from(context), parent, false)
		return MyViewHolder(view)
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val data: UIHourlyForecast = getItem(position)
		holder.bindItem(data)
	}
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<UIHourlyForecast>() {
	override fun areItemsTheSame(
		oldItem: UIHourlyForecast,
		newItem: UIHourlyForecast,
	): Boolean {
		return oldItem.time == newItem.time
	}

	override fun areContentsTheSame(
		oldItem: UIHourlyForecast,
		newItem: UIHourlyForecast,
	): Boolean {
		return oldItem == newItem
	}
}