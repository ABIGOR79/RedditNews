package secondActivity

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.appcompat.widget.SwitchCompat
import com.example.myappapi.R

class SecondActivity : AppCompatActivity() {

    private val APP_PREFERENCES = "mysettings"
    lateinit var mSettings: SharedPreferences

    lateinit var switchTheme: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        switchTheme = findViewById(R.id.switchTheme)

        switchTheme.setOnCheckedChangeListener { switcher: CompoundButton, value: Boolean ->
            if (switcher.isPressed) {
                updateTheme(value)
                mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
                mSettings.edit().putBoolean("Dark", value).apply()
            }
        }
    }

    fun updateTheme(args: Boolean) {
        val mode: Int = if (args) {
            MODE_NIGHT_YES
        } else {
            MODE_NIGHT_NO
        }
        setDefaultNightMode(mode)
        recreate()
    }

}