package com.shift.randomuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.shift.randomuser.databinding.ActivityMainBinding
import com.shift.randomuser.extension.DetailActivity
import com.shift.randomuser.model.response.Results
import com.shift.randomuser.viewmodel.RepositoryViewModel
import com.shift.randomuser.viewmodel.UserInfoAdapter

private const val TAG = "MainActivity"
const val EXTRA_POST_ID = "EXTRA_POST_ID"
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
        userInfoAdapter = UserInfoAdapter(this, results, object: UserInfoAdapter.ItemClickListener {
            override fun onItemClick(res: Results) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val client = Gson().toJson(res)
                intent.putExtra(EXTRA_POST_ID, client)
                startActivity(intent)
            }})
        binding.contentMain.recyclerView.adapter = userInfoAdapter
        binding.contentMain.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.button.setOnClickListener {
            viewModel.getData()
        }
    }
}