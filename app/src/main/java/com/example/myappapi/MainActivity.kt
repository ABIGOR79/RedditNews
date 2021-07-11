package com.example.myappapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import data.RemoteDataSourceImpl
import recycleView.RecycleAdapter
import repo.PostRepositoryImpl

class MainActivity : AppCompatActivity() {

    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter =
            MainPresenter(GetNewsListUseCase(PostRepositoryImpl(RemoteDataSourceImpl())))

        val recyclerView: RecyclerView = findViewById(R.id.listNews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecycleAdapter(mainPresenter.getListNews())
    }

}