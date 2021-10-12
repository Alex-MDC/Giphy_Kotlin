package com.delnortedevs.giphykotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.delnortedevs.giphykotlin.databinding.GiphyItemBinding

class Adapter (val context: Context, var giphys: GiphyResponse) : RecyclerView.Adapter<Adapter.ViewHolder>()      {
    class ViewHolder (val binding: GiphyItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GiphyItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {

            textViewTitle.text = giphys.data[position].title

            Glide.with(context)
                .load(giphys.data[position].images.fixed_height.url)
                .into(imageViewGiphy)
        }
    }
    override fun getItemCount(): Int {
        return giphys.data.size
    }
}
