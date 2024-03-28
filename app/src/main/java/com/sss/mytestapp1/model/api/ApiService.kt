package com.sss.mytestapp1.model.api

import com.sss.mytestapp1.model.modelUser.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // асинхронная функция запроса списка пользователей
    @GET("users")
    suspend fun getUsersFromServer(): Response<User>

}