package com.devmuyiwa.weather.core.util
//
//import android.graphics.*
//import android.view.*
//import android.widget.*
//import androidx.fragment.app.Fragment
//import com.devmuyiwa.weather.*
//import com.google.android.material.snackbar.Snackbar
//
//fun Snackbar.makeCustom(
//	rootView: View,
//	layout: View,
//	message: CharSequence,
//	actionText: CharSequence
//	){
//	val snackBar = Snackbar.make(rootView, "", Snackbar.LENGTH_INDEFINITE)
//	snackBar.view.setBackgroundColor(Color.TRANSPARENT)
//	val customSnackBarLayout = snackBar.view as Snackbar.SnackbarLayout
//	customSnackBarLayout.setPadding(0,0,0,0)
//	layout.findViewById<View>()
//
//	snack.view.setBackgroundColor(Color.TRANSPARENT)
//	val layout = snack.view as Snackbar.SnackbarLayout
//	layout.setPadding(0,0,0,0)
//	custom.findViewById<TextView>(R.id.message).text = toast
//	custom.findViewById<TextView>(R.id.retry_text).setOnClickListener {
//		fetchForecast()
//		snack.dismiss()
//	}
//	layout.addView(custom)
//	snack.show()
//}