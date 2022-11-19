package com.example.retrogfitr.retroggitr

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(val postRestApi: PostRestApi) {
    var posts: List<PostResponse>? = mutableListOf()
    var error: String = ""

    fun getAll(sucsess: () -> Unit) {

        postRestApi.getAll().enqueue(object : Callback<List<PostResponse>> {
            override fun onResponse(
                call: Call<List<PostResponse>>,
                response: Response<List<PostResponse>>,
            ) {
                posts = response.body()
                sucsess()
            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                error = t.message.toString()
            }

        })

    }
}