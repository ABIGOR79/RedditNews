package data

import models.Post

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getListNews(): List<Post> {
        return mutableListOf(
            Post(
                0,
                "weather",
                "weatherUkraine",
                0,
                0,
                "weather of Ukraine",
                "url"
            ),
            Post(
                1,
                "sport",
                "Match Day",
                1,
                1,
                "sport today",
                "url"
            ),
            Post(
                2,
                "News",
                "Ukrainian News",
                2,
                2,
                "News today",
                "url"
            )
        )

    }

    override fun getDetailsNews() {

    }
}

interface RemoteDataSource {
    fun getListNews(): List<Post>
    fun getDetailsNews()

}