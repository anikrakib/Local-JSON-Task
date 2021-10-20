package com.example.taskforjuniordeveloper

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjuniordeveloper.databinding.DataListItemBinding
import kotlin.collections.ArrayList

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var items = ArrayList<Result>()
    lateinit var context: Context

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdateData(
        results: ArrayList<Result>,
        context: Context
    ) {
        this.items = results
        this.context = context
        //notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataListItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
    ) {
        holder.bind(items[position],context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(
        private val binding: DataListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Result,context: Context) {
            binding.apply {
                movieName.text = data.title
                movieDescription.text = data.description
                movieName.setOnClickListener {
                    val intent = Intent(context,DetailsActivity::class.java)
                    intent.putExtra("name",data.title)
                    intent.putExtra("description",data.description)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(intent)
                }
            }
        }
    }

}



