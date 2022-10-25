package com.devmuyiwa.weather.feature_weather.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.*
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(Instant
        .ofEpochSecond(this, 0), ZoneId.systemDefault())
}

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toLocalDate(): LocalDate{
    return Instant.ofEpochSecond(this).atZone(ZoneId.systemDefault()).toLocalDate()
}

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toLocalTime(): LocalTime{
    return Instant.ofEpochSecond(this).atZone(ZoneId.systemDefault()).toLocalTime()
}

fun LocalTime.to12HourFormat(): String{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        this.format(DateTimeFormatter.ofPattern("h a"))
    } else {
        SimpleDateFormat("h a", Locale.getDefault()).format(Calendar.getInstance().time)
    }
}

fun LocalDate.toDate(): String{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        "${this.dayOfWeek.name}, ${this.dayOfWeek.value} ${this.month.name}"
        val date = DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(this.toString())
        "${this.dayOfWeek.name.take(3)}, " +
                DateTimeFormatter.ofPattern("d MMM").format(date)
    } else{
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance())
    }
}
