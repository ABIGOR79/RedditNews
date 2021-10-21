package secondActivity

import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.appcompat.widget.SwitchCompat
import com.example.myappapi.R
import org.koin.android.ext.android.inject
import sharedPref.MySharedPreferences

class SecondActivity : AppCompatActivity() {

    lateinit var switchTheme: SwitchCompat
    lateinit var switchMode: SwitchCompat
    private val settings: MySharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        switchTheme = findViewById(R.id.switchTheme)
        switchMode = findViewById(R.id.switchMode)
        switchTheme.isChecked = settings.getMode()
        switchMode.isChecked = settings.getModeOffline()

        switchTheme.setOnCheckedChangeListener { switcher: CompoundButton, value: Boolean ->
            if (switcher.isPressed) {
                updateTheme(value)
                settings.saveMode(value)
            }
        }
        switchMode.setOnCheckedChangeListener{switcher: CompoundButton, value: Boolean ->
            if (switcher.isPressed) {
                settings.saveModeOffline(value)
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