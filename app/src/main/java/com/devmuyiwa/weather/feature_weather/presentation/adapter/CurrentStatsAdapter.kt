package com.devmuyiwa.weather.feature_weather.presentation.adapter

import android.content.*
import android.view.*
import androidx.recyclerview.widget.*
import com.devmuyiwa.weather.databinding.*
import com.devmuyiwa.weather.feature_weather.presentation.helper.*

class CurrentStatsAdapter(private val context: Context) :
	ListAdapter<Stats, CurrentStatsAdapter.MyViewHolder>(ITEM_COMPARATOR) {
	inner class MyViewHolder(private val binding: LayoutStatsItemBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bindItem(item: Stats) {
			binding.statName.text = item.name
			binding.statValue.text = item.value
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		val view = LayoutStatsItemBinding
			.inflate(LayoutInflater.from(context), parent, false)
		return MyViewHolder(view)
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val data: Stats = getItem(position)
		holder.bindItem(data)
	}

}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<Stats>() {
	override fun areItemsTheSame(
		oldItem: Stats,
		newItem: Stats,
	): Boolean {
		return oldItem.value == newItem.value
	}

	override fun areContentsTheSame(
		oldItem: Stats,
		newItem: Stats,
	): Boolean {
		return oldItem == newItem
	}
}