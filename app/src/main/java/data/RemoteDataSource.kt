package data

import com.example.myappapi.RetrofitServices
import models.Post

class RemoteDataSource(private var client: RetrofitServices): DataSource {

    override fun getListNews(apiKey: String): List<Post> {
        //return client.getNewsList(apiKey)
    return emptyList<Post>()
    }

    override fun getDetailsNews() {
        TODO("Not yet implemented")
    }


}