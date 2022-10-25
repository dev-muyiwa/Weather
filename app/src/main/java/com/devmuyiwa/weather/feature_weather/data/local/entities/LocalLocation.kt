package com.devmuyiwa.weather.feature_weather.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = LocalLocation.LOCATION)
@JsonClass(generateAdapter = true)
data class LocalLocation(
    @PrimaryKey(autoGenerate = false) val name: String,
    val region: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val tzId: String,
    val localtimeEpoch: Long,
    val localtime: String,
){
    companion object {
        const val LOCATION = "location"
    }
}
