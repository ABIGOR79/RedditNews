package sharedPref

import android.content.Context

class MySharedPreferences(context: Context) {

    companion object {
        const val MODE = "mode"
        const val OFFLINE = "offline"
        private const val APP_PREFERENCES = "mysettings"
    }

    private var mSettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    fun saveMode(mode: Boolean){
        mSettings.edit().putBoolean(MODE, mode).apply()
    }

    fun getMode(): Boolean{
        return mSettings.getBoolean(MODE, false)
    }

    fun saveModeOffline(offline: Boolean){
        mSettings.edit().putBoolean(OFFLINE, false)
    }

    fun getModeOffline(): Boolean{
        return mSettings.getBoolean(OFFLINE, false)
    }

}