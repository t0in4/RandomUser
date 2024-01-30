package com.shift.randomuser.viewmodel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.UserInfoResponse
import com.shift.randomuser.model.response.Results
import com.shift.randomuser.R
const val TAG = "UserInfoAdapter"
class UserInfoAdapter(
    private val context: Context,
    private val users: List<UserInfoResponse>
) : RecyclerView.Adapter<UserInfoAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "Posts ${holder.bind(users[position])}")
        holder.bind(users[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView
        var tvAddress: TextView
        var tvPhone: TextView
        var tvPhoto: ImageView
        init {
            tvName = itemView.findViewById(R.id.name)
            tvAddress = itemView.findViewById(R.id.address)
            tvPhone = itemView.findViewById(R.id.phone)
            tvPhoto = itemView.findViewById(R.id.photo)
        }

        fun bind(res: UserInfoResponse) {
            tvName.text = res.results.toString()
            tvAddress.text = res.results.toString()
            tvPhone.text = res.results.toString()
            //tvPhoto.
        }

    }

}