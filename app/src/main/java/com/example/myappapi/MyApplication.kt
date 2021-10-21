package com.example.myappapi

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import sharedPref.MySharedPreferences

class MyApplication: Application() {

    lateinit var mySettings: MySharedPreferences

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MyApplication)
            modules(appModule)
        }

        mySettings = MySharedPreferences(applicationContext)
        updateTheme(mySettings.getMode())
    }

    fun updateTheme(args: Boolean) {
        val mode: Int = if (args) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)

    }
}