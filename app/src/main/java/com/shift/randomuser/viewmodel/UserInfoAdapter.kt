package com.shift.randomuser.viewmodel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.example.Name
import com.example.example.UserInfoResponse
import com.shift.randomuser.R
import com.shift.randomuser.model.response.Results
import com.shift.randomuser.model.response.UserResults
import java.lang.Exception

const val TAG = "UserInfoAdapter"
class UserInfoAdapter(
    private val context: Context,
    private val users: List<Results>,
    //private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<UserInfoAdapter.ViewHolder>(){
    interface ItemClickListener {
        fun onItemClick(item: Results)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_layout,
            parent,
            false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bind(users[position])
        Log.i(TAG, "picture url: ${users[position].picture?.medium}")

        try {
            Glide.with(this.context)
                .load(users[position].picture?.medium)
                .fitCenter()
                //.diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.tvPhoto)
        } catch (e: Exception) {
            Log.e(TAG, "$e")
        }
        holder.tvTitle.text = users[position].name?.title
        holder.tvName.text = users[position].name?.first
        holder.tvSurname.text = users[position].name?.last
        holder.tvAddress.text = users[position].location?.street?.name
        holder.tvNumber.text = users[position].location?.street?.number.toString()
        holder.tvPhone.text = users[position].phone
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvName: TextView
        var tvSurname: TextView
        var tvAddress: TextView
        var tvNumber: TextView
        var tvPhone: TextView
        var tvPhoto: ImageView
        init {
            tvTitle = itemView.findViewById(R.id.title)
            tvName = itemView.findViewById(R.id.name)
            tvSurname = itemView.findViewById(R.id.surname)
            tvAddress = itemView.findViewById(R.id.address)
            tvNumber = itemView.findViewById(R.id.number)
            tvPhone = itemView.findViewById(R.id.phone)
            tvPhoto = itemView.findViewById(R.id.photo)
        }

        //fun bind(res: UserResults) {
/*
            for (i in res.results) {
                tvName.text = i.name.toString()
                tvAddress.text = i.location.toString()
                tvPhone.text = i.phone
                //tvPhoto.
            }
*/
            /*tvName.text = res.results[.
            tvAddress.text = res.results[0].location.toString()
            tvPhone.text = res.results[0].phone*/

        }

    }

