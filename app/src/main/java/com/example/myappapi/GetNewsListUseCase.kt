package com.example.myappapi

import models.Post
import repo.PostRepository

class GetNewsListUseCase(private val repo: PostRepository) {
    fun showListNews(): List<Post> {
         return repo.getListNews()
    }
}