package com.devmuyiwa.weather.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.devmuyiwa.weather.model.WeatherData
import com.devmuyiwa.weather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository)
    : ViewModel() {
    private val _resp = MutableLiveData<WeatherData>()
    val weatherResponse: LiveData<WeatherData>
        get() = _resp

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            repository.getWeather().let { response ->
                if(response.isSuccessful){
                    _resp.postValue(response.body())
                } else{
                    Log.d("Tag", "getWeather() error response: ${response.message()}")
                }
            }
        }
    }

}