package com.shift.randomuser.extension

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shift.randomuser.model.api.RetrofitInstance
import com.shift.randomuser.model.api.UserApi
import com.shift.randomuser.model.response.Results
import com.shift.randomuser.model.response.UserResults
import kotlinx.coroutines.launch

const val TAG = "DetailViewModel"
class DetailViewModel : ViewModel() {
    private val _data: MutableLiveData<Results> = MutableLiveData()
    val data: LiveData<Results>
        get() = _data

    fun getUserDetails(res: Results) {

        viewModelScope.launch {
            val fetchedUser = res
            Log.i(TAG, "fetched user: $fetchedUser")
            _data.value = fetchedUser


        }
    }
}

