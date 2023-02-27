package com.example.home

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("mahasiswa")
    fun data(): Call<Mahasiswa>
}