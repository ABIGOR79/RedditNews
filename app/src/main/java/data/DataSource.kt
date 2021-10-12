package data

import models.Post
import java.text.DateFormat

class RemoteDataSourceImpl : RemoteDataSource {
    override fun getListNews(): List<Post> {
        return mutableListOf(
            Post(
                dataTime(System.currentTimeMillis()),
                "weather",
                "weather",
                0,
                0,
                "Weather of Ukraine",
                "https://png.pngtree.com/element_our/20190523/ourmid/pngtree-cartoon-hand-drawn-weather-forecast-png-element-image_1083383.jpg"
            ),
            Post(
                dataTime(System.currentTimeMillis() - (1*24*60*60*1000)),
                "sport",
                "match Day",
                1,
                1,
                "Sport today",
                "https://png.pngtree.com/element_our/20190602/ourlarge/pngtree-running-sport-figure-silhouette-image_1378368.jpg"
            ),
            Post(
                dataTime(System.currentTimeMillis() -(1*24*60*60*1000*7)),
                "news",
                "ukrainian news",
                2,
                2,
                "News today",
                "https://img1.freepng.ru/20180831/zkh/kisspng-logo-font-brand-product-line-breaking-news-stickers-by-hien-ton-5b895539d09b43.4231607215357269058545.jpg"
            )
        )

    }

    fun dataTime(time: Long): String {
        return DateFormat.getInstance().format(time)

    }

    override fun getDetailsNews() {

    }
}

interface RemoteDataSource {
    fun getListNews(): List<Post>
    fun getDetailsNews()

}