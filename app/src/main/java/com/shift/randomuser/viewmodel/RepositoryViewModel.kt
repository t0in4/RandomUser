package com.shift.randomuser.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shift.randomuser.model.response.Results
//import com.shift.randomuser.model.Repository
import com.shift.randomuser.model.api.RetrofitInstance
import kotlinx.coroutines.launch

class RepositoryViewModel(
    //private val repository: Repository = Repository()
): ViewModel() {
    val _responseState: MutableLiveData<List<Results>> = MutableLiveData()
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
    val responseState: LiveData<List<Results>>
        get() = _responseState

    fun getData() {
        viewModelScope.launch {
            val fetchedUsers = RetrofitInstance.api.getUInfo()
            Log.i(TAG, "fetched posts: $fetchedUsers")
            _responseState.value = fetchedUsers
        }
    }

}