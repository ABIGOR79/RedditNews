package com.example.myappapi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Post
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import recycleView.RecycleAdapter
import secondActivity.SecondActivity

class MainActivity : AppCompatActivity(), MainContract {

    private val mainPresenter: MainPresenter by inject{ parametersOf(this)}
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView  = findViewById(R.id.listNews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mainPresenter.getListNews()
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

    override fun showNews(news: List<Post>) {
        recyclerView.adapter = RecycleAdapter(news)
    }

}

