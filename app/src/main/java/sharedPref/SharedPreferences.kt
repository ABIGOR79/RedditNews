package sharedPref

import android.content.Context

class MySharedPreferences(context: Context) {

    companion object {
        const val MODE = "mode"
        private const val APP_PREFERENCES = "mysettings"
    }

    private var mSettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    fun saveMode(mode: Boolean){
        mSettings.edit().putBoolean(MODE, mode).apply()
    }

    fun getMode(): Boolean{
        return mSettings.getBoolean(MODE, false)
    }

}