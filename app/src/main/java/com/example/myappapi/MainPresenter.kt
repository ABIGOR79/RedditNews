package com.example.myappapi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import models.Post


class MainPresenter(
    private val getListUseCase: GetNewsListUseCase,
    private val view: MainContract
) {

    private var viewModelJob = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var scopeIO = CoroutineScope(Dispatchers.IO + viewModelJob)
    fun getListNews() {

        scopeIO.launch {

            val result= getListUseCase.showListNews()
            uiScope.launch { view.showNews(result) }
        }
    }

}


interface MainContract {
    fun showNews(news: List<Post>)
}

