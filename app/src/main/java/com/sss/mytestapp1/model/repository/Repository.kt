package com.sss.mytestapp1.model.repository

import com.sss.mytestapp1.model.api.RetrofitInstance
import com.sss.mytestapp1.model.modelUser.User
import retrofit2.Response

class Repository {

    suspend fun getUsersFromServer(): Response<User> {
        return RetrofitInstance.api.getUsersFromServer()
    }

}