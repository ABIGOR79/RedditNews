package data.models

data class NewsResponse(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Artical>? = null
)

data class Artical(
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null
)

data class Source (
    val id: Int? = null,
    val name: String? = null
)