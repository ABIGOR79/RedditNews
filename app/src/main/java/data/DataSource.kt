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
                "https://png.pngtree.com/element_our/20190523/ourmid/pngtree-cartoon-hand-drawn-weather-forecast-png-element-image_1083383.jpg"
            ),
            Post(
                1,
                "sport",
                "Match Day",
                1,
                1,
                "sport today",
                "https://png.pngtree.com/element_our/20190602/ourlarge/pngtree-running-sport-figure-silhouette-image_1378368.jpg"
            ),
            Post(
                2,
                "News",
                "Ukrainian News",
                2,
                2,
                "News today",
                "https://img1.freepng.ru/20180831/zkh/kisspng-logo-font-brand-product-line-breaking-news-stickers-by-hien-ton-5b895539d09b43.4231607215357269058545.jpg"
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