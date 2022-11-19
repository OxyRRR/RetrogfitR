package com.example.retrogfitr.retroggitr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrogfitr.R
import com.example.retrogfitr.databinding.PostListItemBinding

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private var posts: List<PostResponse> = mutableListOf()

    fun setPosts(list: List<PostResponse>?){
        if (list != null) {
            posts = list
            notifyDataSetChanged()
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = PostListItemBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.post = posts[position]
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}