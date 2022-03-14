package data

import com.example.myappapi.RetrofitServices
import data.models.NewsResponse
import models.Post
import java.text.SimpleDateFormat

class RemoteDataSource(private var client: RetrofitServices): DataSource {
    private lateinit var time: LocalDataSourceImpl
    override suspend fun getListNews(apiKey: String): List<Post> {
        val result = mutableListOf<Post>()
        val apiResult: NewsResponse = client.getNewsList(apiKey)

        for (artical in apiResult.articles!!) {
            result.add(
                Post(
                    postData = changeDateFormat(artical.publishedAt!!),
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

    private fun changeDateFormat(strDate:String) :String{
        val sourceSdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val requiredSdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return requiredSdf.format(sourceSdf.parse(strDate))
    }
}