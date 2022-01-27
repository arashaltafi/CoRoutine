package com.arash.altafi.coroutine.sample2

import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts() : MutableList<Model>

}
