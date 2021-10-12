package com.example.encoderdecoderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class CodeRVAdapter (private val phrases: ArrayList<Coding>): RecyclerView.Adapter<CodeRVAdapter.VideoViewHolder>(){
    class VideoViewHolder(item_row: View): RecyclerView.ViewHolder(item_row){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_row,
            parent,
            false
        )
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val phrase=phrases[position]
        holder.itemView.apply{
            textView2.text= phrase.original
            textView3.text=phrase.changes

        }
    }

    override fun getItemCount() = phrases.size
}