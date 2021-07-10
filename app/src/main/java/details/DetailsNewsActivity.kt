package details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myappapi.R
import data.RemoteDataSourceImpl
import repo.PostRepositoryImpl

class DetailsNewsActivity : AppCompatActivity() {
    lateinit var detailsRepo: PostRepositoryImpl
    lateinit var detailsDataSource: RemoteDataSourceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_news)
    }
}