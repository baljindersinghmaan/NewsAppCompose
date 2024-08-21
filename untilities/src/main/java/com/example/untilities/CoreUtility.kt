package com.example.untilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object CoreUtility {

    fun isInternetConnected(context: Context) : Boolean{
        val connectvityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectvityManager.activeNetwork ?: return false
        val actNw = connectvityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        val result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return result
    }
}