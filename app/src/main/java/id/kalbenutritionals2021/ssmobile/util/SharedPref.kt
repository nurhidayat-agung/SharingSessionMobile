package id.kalbenutritionals2021.ssmobile.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import id.kalbenutritionals2021.ssmobile.model.general.DeviceInfo

class SharedPref(private val context: Context) {
    val gson = Gson()

    companion object {
        private const val SHARED_PREF = "New_FPRS"
        @JvmField
        val HAS_OPEN_SHAREDPREF = "has_open_New_FPRS"
    }

    private val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences(
            SHARED_PREF,
            Context.MODE_PRIVATE
        )
    }

    fun putBool(key: String, value: Boolean)
    {
        sharedPref.edit().putBoolean(key,value).apply()
    }

    fun getBool(key: String,defValue:Boolean=false):Boolean
    {
        return sharedPref.getBoolean(key, defValue)
    }

    fun getString(key: String,defValue: String=""):String
    {
        return sharedPref.getString(key,defValue).toString()
    }

    fun putString(key: String, value: String)
    {
        sharedPref.edit().putString(key,value).apply()
    }

    fun putInt(key: String, value: Int)
    {
        sharedPref.edit().putInt(key,value).apply()
    }

    fun getInt(key: String,defValue: Int = 0):Int
    {
        return sharedPref.getInt(key,defValue)
    }

    fun getDeviceInfo(): DeviceInfo {
        val devideInfoString  = sharedPref.getString(Constants.DeviceTag.deviceInfo,"")
        return gson.fromJson(devideInfoString, DeviceInfo::class.java)
    }


    fun reset() {
        sharedPref.edit().clear().apply()
    }
}



