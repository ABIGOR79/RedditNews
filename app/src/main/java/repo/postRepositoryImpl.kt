package repo

import data.RemoteDataSource
import models.Post


class PostRepositoryImpl(private val remoteDataSource: RemoteDataSource): PostRepository {


    override fun getListNews(): List<Post> {
        return remoteDataSource.getListNews()
    }

    override fun getDetailsNews() {
        TODO("Not yet implemented")
    }
}

interface PostRepository {
    fun getListNews (): List<Post>
    fun getDetailsNews()
}