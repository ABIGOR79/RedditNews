package repo

import data.DataSource
import models.Post
import sharedPref.MySharedPreferences


class PostRepositoryImpl(
    private var localDataSource: DataSource,
    private val remoteDataSource: DataSource,
    private var mySettings: MySharedPreferences
) : PostRepository {




    override fun getListNews(): List<Post> {
        return if (mySettings.getModeOffline()) {
            localDataSource.getListNews()
        } else {
            remoteDataSource.getListNews()
        }

    }

    override fun getDetailsNews() {
        TODO("Not yet implemented")
    }
}

interface PostRepository {
    fun getListNews(): List<Post>
    fun getDetailsNews()
}