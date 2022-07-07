package com.example.drinkapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.drinkapp.Repository.RepositoryDrink

lateinit var REPOSITORY: RepositoryDrink

@SuppressLint("MissingPermission")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun isConnectedNewApi(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        cm.getNetworkCapabilities(cm.activeNetwork)
    } else {
        TODO("VERSION.SDK_INT < M")
    }
    return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
}

@SuppressLint("MissingPermission")
@Suppress("DEPRECATION")
fun isConnectedOld(context: Context): Boolean? {
    val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connManager.activeNetworkInfo
    return networkInfo?.isConnected
}

 fun isConnected(context: Context): Boolean? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        isConnectedNewApi(context)
    } else {
        isConnectedOld(context)
    }
}