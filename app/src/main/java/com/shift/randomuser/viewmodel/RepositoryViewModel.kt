package com.shift.randomuser.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.UserInfoResponse
import com.shift.randomuser.model.response.Results
//import com.shift.randomuser.model.Repository
import com.shift.randomuser.model.api.RetrofitInstance
import com.shift.randomuser.model.response.UserResults
import kotlinx.coroutines.launch

class RepositoryViewModel(
    //private val repository: Repository = Repository()
): ViewModel() {
    private val _responseState: MutableLiveData<List<UserResults>> = MutableLiveData()
/*
    suspend fun getUInfo(): List<Results> {
        return repository.getUInfo().results
    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val userInfo = getUInfo()
            responseState.value = userInfo
        }
    }
*/
    val responseState: LiveData<List<UserResults>>
        get() = _responseState

    fun getData() {
        viewModelScope.launch {
            val fetchedUsers = RetrofitInstance.api.getUInfo()
            Log.i(TAG, "fetched posts: $fetchedUsers")
            _responseState.value = listOf(fetchedUsers)
        }
    }

}