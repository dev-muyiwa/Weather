package com.devmuyiwa.weather.feature_weather.presentation.adapter

import android.content.*
import android.view.*
import androidx.recyclerview.widget.*
import coil.*
import com.devmuyiwa.weather.databinding.*
import com.devmuyiwa.weather.feature_weather.presentation.helper.*

class HourlyStatsAdapter(private val context: Context) :
	ListAdapter<UIHourlyStats, HourlyStatsAdapter.MyViewHolder>(ITEM_COMPARATOR) {
	inner class MyViewHolder(private val binding: LayoutHourlyForecastItemBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bindItem(item: UIHourlyStats) {
			binding.hourTime.text = item.time
			binding.weatherIcon.load(item.icon) // add error drawable
			binding.hourTemperature.text = item.temperature
		}

	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		val view = LayoutHourlyForecastItemBinding
			.inflate(LayoutInflater.from(context), parent, false)
		return MyViewHolder(view)
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val data: UIHourlyStats = getItem(position)
		holder.bindItem(data)
	}
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<UIHourlyStats>() {
	override fun areItemsTheSame(
		oldItem: UIHourlyStats,
		newItem: UIHourlyStats,
	): Boolean {
		return oldItem.time == newItem.time
	}

	override fun areContentsTheSame(
		oldItem: UIHourlyStats,
		newItem: UIHourlyStats,
	): Boolean {
		return oldItem == newItem
	}
}