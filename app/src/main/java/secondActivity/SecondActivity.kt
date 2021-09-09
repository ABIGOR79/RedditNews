package secondActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import com.example.myappapi.R

class SecondActivity : AppCompatActivity() {
    lateinit var switchTheme: Switch
    lateinit var switchMode: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

    }
}