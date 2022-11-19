package com.example.retrogfitr.retroggitr;

import android.telecom.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface PostRestApi<id, Int, postResponse> {

   @GET ("posts/{id}")
   fun getById(@Path("id")id): Int):Call<PostResponse>

    @GET("posts")
   fun getAll(): Call<List<PostResponse>>

    @POST ("post")
  fun insert(@Body postResponse: PostResponse): Call<PostResponse>
}