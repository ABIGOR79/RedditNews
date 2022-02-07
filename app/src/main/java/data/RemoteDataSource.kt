package data

import com.example.myappapi.RetrofitServices
import data.models.NewsResponse
import models.Post

class RemoteDataSource(private var client: RetrofitServices): DataSource {
    private lateinit var time: LocalDataSourceImpl
    override suspend fun getListNews(apiKey: String): List<Post> {
        val result = mutableListOf<Post>()
        val apiResult: NewsResponse = client.getNewsList(apiKey)

        for (artical in apiResult.articles!!) {
            result.add(
                Post(
                    postData = time.dataTime((artical.publishedAt!!).toLong()),
                    postCategory = "News",
                    postTitle = artical.title!!,
                    postLike = 0,
                    postComments = 0,
                    postDescription = artical.description!!,
                    postPics = artical.urlToImage
                )
            )
        }


        return result
    }

    override fun getDetailsNews() {
        TODO("Not yet implemented")
    }

    /*fun dataTime(time: String): String {
        return DateFormat.getInstance().format(time)
    }*/
}