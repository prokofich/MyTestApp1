package com.sss.mytestapp1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sss.mytestapp1.model.modelUser.User
import com.sss.mytestapp1.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class UsersViewModel:ViewModel() {

    private val repository = Repository()
    var users: MutableLiveData<Response<User>> = MutableLiveData()

    fun getUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            val answer = repository.getUsersFromServer()
            withContext(Dispatchers.Main){
                users.value = answer
            }
        }
    }

}