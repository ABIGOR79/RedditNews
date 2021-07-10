package com.example.myappapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import data.RemoteDataSourceImpl
import repo.PostRepositoryImpl

class MainActivity : AppCompatActivity() {
    lateinit var mainPresenter: MainPresenter
    lateinit var dataSource: RemoteDataSourceImpl
    lateinit var comonRepo: PostRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.getListNews()
    }
}