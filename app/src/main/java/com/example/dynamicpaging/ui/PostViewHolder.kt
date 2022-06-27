package com.example.dynamicpaging.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicpaging.R
import com.example.dynamicpaging.vo.RedditPost

/**
 * A RecyclerView ViewHolder that displays a reddit post.
 */
class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.title)
    private val description: TextView = view.findViewById(R.id.description)

    fun bind(redditPost: RedditPost?) {
        title.text = redditPost?.title ?: "loading"
        description.text = itemView.context.resources.getString(
            R.string.post_subtitle,
            redditPost?.author ?: "unknown"
        )
    }

    companion object {
        fun create(parent: ViewGroup): PostViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
            return PostViewHolder(view)
        }
    }
}