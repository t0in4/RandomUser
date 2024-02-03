package com.shift.randomuser.extension

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.shift.randomuser.databinding.ActivityDetailBinding
import com.shift.randomuser.model.response.Results


const val EXTRA_POST_ID = "EXTRA_POST_ID"
class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val string = intent.getStringExtra(EXTRA_POST_ID)
        val res = Gson().fromJson(string, Results::class.java)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.data.observe( this, Observer {data ->
            binding.tvName.text = data.name.toString()
            binding.tvLocation.text = data.location.toString()
            binding.tvEmail.text = data.email.toString()
        })
        viewModel.getUserDetails(res)
    }



}