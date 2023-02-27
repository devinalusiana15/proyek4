package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R

class MateriAdapter(
    val materi:ArrayList<MateriModel.Data>,
    val listener: OnAdapterListener
    ):RecyclerView.Adapter<MateriAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int)=ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_mater,parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = materi[position]
        holder.textMateri.text = data.judul_materi
        holder.itemView.setOnClickListener{
            listener.onClick(data)
        }
    }

    override fun getItemCount()=materi.size

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val textMateri = view.findViewById<TextView>(R.id.text_materi)
    }

    public fun setData(data: List<MateriModel.Data>){
        materi.clear()
        materi.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(materi: MateriModel.Data)
    }
}