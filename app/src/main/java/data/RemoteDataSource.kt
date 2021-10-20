package data

import models.Post

class RemoteDataSource(): DataSource {

    override fun getListNews(): List<Post> {
        return emptyList()
    }

    override fun getDetailsNews() {
        TODO("Not yet implemented")
    }


}