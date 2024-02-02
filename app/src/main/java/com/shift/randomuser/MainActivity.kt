package com.shift.randomuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example.UserInfoResponse
import com.shift.randomuser.databinding.ActivityMainBinding
import com.shift.randomuser.model.response.Results
import com.shift.randomuser.model.response.UserResults
import com.shift.randomuser.viewmodel.RepositoryViewModel
import com.shift.randomuser.viewmodel.UserInfoAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RepositoryViewModel
    private lateinit var userInfoAdapter: UserInfoAdapter
    private var results = mutableListOf<Results>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[RepositoryViewModel::class.java]
        viewModel.responseState.observe(this, Observer {responseState ->
            //Log.i(TAG, "Number of users: ${responseState.size}")
            results.addAll(responseState)
            userInfoAdapter.notifyDataSetChanged()
        })
        userInfoAdapter = UserInfoAdapter(this, results)
        binding.contentMain.recyclerView.adapter = userInfoAdapter
        binding.contentMain.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.button.setOnClickListener {
            viewModel.getData()
        }
    }
}