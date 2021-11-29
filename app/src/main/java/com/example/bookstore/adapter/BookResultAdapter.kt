package com.example.bookstore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookstore.Volume
import java.util.*

/**
 * Adapter
 */
class BookResultsAdapter :
    RecyclerView.Adapter<BookResultsAdapter.BookSearchResultHolder>() {

    private var results: List<Volume> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchResultHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(com.example.bookstore.R.layout.book_item, parent, false)
        return BookSearchResultHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookSearchResultHolder, position: Int) {
        val volume = results[position]
        holder.titleTextView.text = volume.volumeInfo?.title
        holder.publishedDateTextView.text = volume.volumeInfo?.publishedDate

        if (volume.volumeInfo?.imageLinks != null) {
            val imageUrl = volume.volumeInfo?.imageLinks?.smallThumbnail
                ?.replace("http://", "https://")

            Glide.with(holder.itemView)
                .load(imageUrl)
                .into(holder.smallThumbnailImageView)
        }
        if (volume.volumeInfo?.authors != null) {
            val u = com.example.bookstore.util.Util()
            val authors = u.StringJoin(volume.volumeInfo?.authors!!, ", ")
            holder.authorsTextView.text = authors
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    fun setResults(results: List<Volume>) {
        this.results = results
        notifyDataSetChanged()
    }

    class BookSearchResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView =
            itemView.findViewById<TextView>(com.example.bookstore.R.id.book_item_title)
        val authorsTextView =
            itemView.findViewById<TextView>(com.example.bookstore.R.id.book_item_authors)
        val publishedDateTextView =
            itemView.findViewById<TextView>(com.example.bookstore.R.id.book_item_publishedDate)
        val smallThumbnailImageView =
            itemView.findViewById<ImageView>(com.example.bookstore.R.id.book_item_smallThumbnail)
    }
}