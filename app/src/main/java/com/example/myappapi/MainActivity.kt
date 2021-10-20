package com.example.myappapi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import data.LocalDataSourceImpl
import data.RemoteDataSource
import recycleView.RecycleAdapter
import repo.PostRepositoryImpl
import secondActivity.SecondActivity
import sharedPref.MySharedPreferences

class MainActivity : AppCompatActivity() {


    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter =
            MainPresenter(GetNewsListUseCase(PostRepositoryImpl(LocalDataSourceImpl(),RemoteDataSource(),
                MySharedPreferences(applicationContext)
            )))

        val recyclerView: RecyclerView = findViewById(R.id.listNews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecycleAdapter(mainPresenter.getListNews())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)

        val settingsItem: MenuItem? = menu!!.findItem(R.id.settings)
        settingsItem?.setOnMenuItemClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            true
        }

        return super.onCreateOptionsMenu(menu)
    }

}

