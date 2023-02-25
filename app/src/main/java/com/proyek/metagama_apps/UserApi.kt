package com.proyek.metagama_apps

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("api/login")
    fun login (
        @Body userRequest: UserRequest
    ): Call<UserResponse>
}