package com.example.myappapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import data.RemoteDataSourceImpl
import repo.PostRepositoryImpl

class MainActivity : AppCompatActivity() {

    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter =
            MainPresenter(GetNewsListUseCase(PostRepositoryImpl(RemoteDataSourceImpl())))

        mainPresenter.getListNews()
    }

}