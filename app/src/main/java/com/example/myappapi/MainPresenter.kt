package com.example.myappapi

import models.Post

class MainPresenter(private val getListUseCase: GetNewsListUseCase) {
    fun getListNews(): List<Post> {
        return getListUseCase.showListNews()
    }
}