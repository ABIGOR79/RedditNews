package repo

import data.DataSource
import models.Post
import sharedPref.MySharedPreferences


class PostRepositoryImpl(
    private var localDataSource: DataSource,
    private val remoteDataSource: DataSource,
    private var mySettings: MySharedPreferences
) : PostRepository {

    private val API_KEY = "add38157867d495887bebcf5c146eaa8"


    override suspend fun getListNews(): List<Post> {
        return if (mySettings.getModeOffline()) {
            localDataSource.getListNews(API_KEY)
        } else {
            remoteDataSource.getListNews(API_KEY)
        }

    }

    override fun getDetailsNews() {
        TODO("Not yet implemented")
    }
}

interface PostRepository {
    suspend fun getListNews(): List<Post>
    fun getDetailsNews()
}