package com.example.retrogfitr.retroggitr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrogfitr.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()   // инициализация библиотеки
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postApi = retrofit.create(PostRestApi::class.java) // инициадизация API

        val repository = PostRepository(postApi)
        val adapter = PostListAdapter()
        binding.postListRecyclerview.adapter = adapter

        repository.getAll {
            adapter.setPosts(repository.posts)
        }


    }
}