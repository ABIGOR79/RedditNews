package com.example.myappapi

import models.Post
import repo.PostRepository

class GetNewsListUseCase(private val repo: PostRepository) {
    suspend fun showListNews(): List<Post> {
         return repo.getListNews()
    }
}